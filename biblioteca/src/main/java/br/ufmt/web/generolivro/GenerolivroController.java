package br.ufmt.web.generolivro;
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
@RequestMapping(path = "/generolivro")
@RequiredArgsConstructor

public class GenerolivroController {
    private final GenerolivroRepository repository;

    @GetMapping(path = "/")
    public List<GeneroLivro> index(){
      return repository.findAll();
    }

    @GetMapping(path = "/{id}")
  public ResponseEntity<GenerolivroResponse> getById(@PathVariable(name = "id") int id) {
    Optional<GeneroLivro> found = repository.findById(id);
    if(found.isPresent()){
     // GenerolivroResponse response = GenerolivroResponse.from(found.get());
     // return ResponseEntity.ok().body(response);
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
public ResponseEntity cadastrar(@RequestBody GenerolivroRequest request){
  GeneroLivro generoLivro = new GeneroLivro();
  generoLivro.setLivro(request.getLivro());
  generoLivro.setGenero(request.getGenero());

  try {
    repository.save(generoLivro);
  } catch(IllegalArgumentException error){
    return ResponseEntity.badRequest().body("Dados Inválido!");
  }
  return ResponseEntity.status(HttpStatus.CREATED).build();

}

@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id,
                              @RequestBody GenerolivroRequest request){
 GeneroLivro generoLivro = new GeneroLivro();
  generoLivro.setId(id);
  generoLivro.setLivro(request.getLivro());
  generoLivro.setGenero(request.getGenero());

  try {
    repository.save(generoLivro);
  } catch(IllegalArgumentException error){
    error.printStackTrace();
    return ResponseEntity.badRequest().build();
  }
  return ResponseEntity.ok().build();
}
    
}
