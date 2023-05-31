package br.ufmt.web.genero;
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
@RequestMapping(path = "/genero")
@RequiredArgsConstructor

public class GeneroController {
    private final GeneroRepository repository;

    @GetMapping(path = "/")
    public List<Genero> index(){
      return repository.findAll();
    }

    @GetMapping(path = "/{id}")
  public ResponseEntity<GeneroResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Genero> found = repository.findById(id);
    if(found.isPresent()){
     // GeneroResponse response = GeneroResponse.from(found.get());
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
public ResponseEntity cadastrar(@RequestBody GeneroRequest request){
  Genero genero = new Genero();
  genero.setNome(request.getNome());
  genero.setId(request.getId());

  try {
    repository.save(genero);
  } catch(IllegalArgumentException error){
    return ResponseEntity.badRequest().body("Dados Inválido!");
  }
  return ResponseEntity.status(HttpStatus.CREATED).build();

}

@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id,
                              @RequestBody GeneroRequest request){
  Genero genero = new Genero();
  genero.setId(id);
  genero.setNome(request.getNome());

  try {
    repository.save(genero);
  } catch(IllegalArgumentException error){
    error.printStackTrace();
    return ResponseEntity.badRequest().build();
  }
  return ResponseEntity.ok().build();
}
    
}
