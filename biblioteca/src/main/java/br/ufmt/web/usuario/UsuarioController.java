package br.ufmt.web.usuario;
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
@RequestMapping(path = "/usuario")
@RequiredArgsConstructor

public class UsuarioController {
    private final UsuarioRepository repository;

    @GetMapping(path = "/")
    public List<Usuario> index(){
      return repository.findAll();
    }

    @GetMapping(path = "/{id}")
  public ResponseEntity<UsuarioResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Usuario> found = repository.findById(id);
    if(found.isPresent()){
     // UsuarioResponse response = UsuarioResponse.from(found.get());
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
public ResponseEntity cadastrar(@RequestBody UsuarioRequest request){
  Usuario usuario = new Usuario();
  usuario.setNome(request.getNome());
  usuario.setCpf(request.getCpf());
  usuario.setEndereco(request.getEndereco());


  try {
    repository.save(usuario);
  } catch(IllegalArgumentException error){
    return ResponseEntity.badRequest().body("Dados Inválido!");
  }
  return ResponseEntity.status(HttpStatus.CREATED).build();

}

@PatchMapping(path = "/{id}")
public ResponseEntity atualizar(@PathVariable int id,
                              @RequestBody UsuarioRequest request){
 Usuario usuario = new Usuario();
  usuario.setId(id);
  usuario.setNome(request.getNome());
   usuario.setEndereco(request.getEndereco());
   usuario.setCpf(request.getCpf());

  try {
    repository.save(usuario);
  } catch(IllegalArgumentException error){
    error.printStackTrace();
    return ResponseEntity.badRequest().build();
  }
  return ResponseEntity.ok().build();
}
    
}
