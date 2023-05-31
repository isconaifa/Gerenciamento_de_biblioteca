package br.ufmt.web.reserva;
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
@RequestMapping(path = "/reserva")
@RequiredArgsConstructor


public class ReservaController {
    private final ReservaRepository repository;

    @GetMapping(path = "/")
    public List<Reserva> index(){
      return repository.findAll();
    }

    @GetMapping(path = "/{id}")
  public ResponseEntity<ReservaResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Reserva> found = repository.findById(id);
    if(found.isPresent()){
     // ReservaResponse response = ReservaResponse.from(found.get());
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
public ResponseEntity cadastrar(@RequestBody ReservaRequest request){
  Reserva reserva = new Reserva();
  reserva.setData_reserva(request.getData_reserva());
  reserva.setData_devolucao(request.getData_devolucao()); 
  reserva.setId(request.getId());

  try {
    repository.save(reserva);
  } catch(IllegalArgumentException error){
    return ResponseEntity.badRequest().body("Dados Inválido!");
  }
  return ResponseEntity.status(HttpStatus.CREATED).build();

}

@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id,
                              @RequestBody ReservaRequest request){
 Reserva reserva = new Reserva();
 reserva.setData_reserva(request.getData_reserva());
 reserva.setData_devolucao(request.getData_devolucao()); 
 reserva.setId(request.getId());
  try {
    repository.save(reserva);
  } catch(IllegalArgumentException error){
    error.printStackTrace();
    return ResponseEntity.badRequest().build();
  }
  return ResponseEntity.ok().build();
}
    
    
}
