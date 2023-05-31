package br.ufmt.web.livro;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping(path = "/livro")
@RequiredArgsConstructor


public class LivroController {
    private final LivroRepository repository;

    @GetMapping(path = "/")
    public List<Livro> index(){
      return repository.findAll();
    }

    @GetMapping(path = "/{id}")
  public ResponseEntity<LivroResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Livro> found = repository.findById(id);
    if(found.isPresent()){
     LivroResponse response = LivroResponse.from(found.get());
     return ResponseEntity.ok().body(response);
    }
    return ResponseEntity.notFound().build();

}

@DeleteMapping(path = "/{pk}")
public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
  try {
    repository.deleteById(id);
    return ResponseEntity.ok().build();
  } catch(EmptyResultDataAccessException erro){
    return ResponseEntity.notFound().build();
  }
}

@PostMapping
public ResponseEntity cadastrar(@RequestBody LivroRequest request){
  Livro livro = new Livro();
  livro.setISBN(request.getISBN());
  livro.setTitulo(request.getTitulo());
  livro.setId(request.getId());

  try {
    repository.save(livro);
  } catch(IllegalArgumentException error){
    return ResponseEntity.badRequest().body("Dados Inválido!");
  }
  return ResponseEntity.status(HttpStatus.CREATED).build();

}

@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id, @RequestBody LivroRequest request){
 Livro livro = new Livro();
 livro.setISBN(request.getISBN());
 livro.setTitulo(request.getTitulo());
 livro.setId(request.getId());

  try {
    repository.save(livro);
  } catch(IllegalArgumentException error){
    error.printStackTrace();
    return ResponseEntity.badRequest().build();
  }
  return ResponseEntity.ok().build();
}
}
