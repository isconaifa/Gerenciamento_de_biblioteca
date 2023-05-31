package br.ufmt.web.reservalivro;
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
@RequestMapping(path = "/reservalivro")
@RequiredArgsConstructor

public class ReservalivroController {
    private final ReservalivroRepository repository;

    @GetMapping(path = "/")
    public List<ReservaLivro> index(){
      return repository.findAll();
    }

    @GetMapping(path = "/{id}")
  public ResponseEntity<ReservalivroResponse> getById(@PathVariable(name = "id") int id) {
    Optional<ReservaLivro> found = repository.findById(id);
    if(found.isPresent()){
     // ReservalivroResponse response = ReservalivroResponse.from(found.get());
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
public ResponseEntity cadastrar(@RequestBody ReservalivroRequest request){
  ReservaLivro reservaLivro = new ReservaLivro();
  reservaLivro.setReserva(request.getReserva());
  reservaLivro.setLivro(request.getLivro());
 reservaLivro.setId(request.getId());
  try {
    repository.save(reservaLivro);
  } catch(IllegalArgumentException error){
    return ResponseEntity.badRequest().body("Dados Inválido!");
  }
  return ResponseEntity.status(HttpStatus.CREATED).build();

}

@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id,
                              @RequestBody ReservalivroRequest request){
 ReservaLivro reservaLivro = new ReservaLivro();
  reservaLivro.setId(id);
  reservaLivro.setReserva(request.getReserva());
  reservaLivro.setLivro(request.getLivro());

  try {
    repository.save(reservaLivro);
  } catch(IllegalArgumentException error){
    error.printStackTrace();
    return ResponseEntity.badRequest().build();
  }
  return ResponseEntity.ok().build();
}
    
}
