package br.ufmt.web.autorlivro;
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

public class AutorlivroController {


@RestController
@RequestMapping(path = "/autorlivro")
@RequiredArgsConstructor
public class AutorController {

    private final AutorlivroRepository repository;

    @GetMapping(path = "/")
    public List<AutorLivro> index(){
      return repository.findAll();
    }

    @GetMapping(path = "/{id}")
  public ResponseEntity<AutorlivroResponse> getById(@PathVariable(name = "id") int id) {
    Optional<AutorLivro> found = repository.findById(id);
    if(found.isPresent()){
      AutorlivroResponse response = AutorlivroResponse.from(found.get());
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
public ResponseEntity cadastrar(@RequestBody AutorlivroRequest request){
  AutorLivro autorLivro = new AutorLivro();
  autorLivro.setLivro(request.getLivro());
  autorLivro.setAutor(request.getAutor());

  try {
    repository.save(autorLivro);
  } catch(IllegalArgumentException error){
    return ResponseEntity.badRequest().body("Dados Inválido!");
  }
  return ResponseEntity.status(HttpStatus.CREATED).build();

}

@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id,
                              @RequestBody AutorlivroRequest request){
  AutorLivro autorLivro = new AutorLivro();
    autorLivro.setId(id);
    autorLivro.setLivro(request.getLivro());
    autorLivro.setAutor(request.getAutor());

  try {
    repository.save(autorLivro);
  } catch(IllegalArgumentException error){
    error.printStackTrace();
    return ResponseEntity.badRequest().build();
  }
  return ResponseEntity.ok().build();
}
    
}
}
