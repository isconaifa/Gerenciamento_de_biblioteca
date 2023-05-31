package br.ufmt.web.autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AutorResponse {
    private int id;
    private String nome;
    private String endereco;
    private String cpf;

public static AutorResponse from(Autor entidade){
    AutorResponse response = new AutorResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setCpf(entidade.getCpf());
    response.setEndereco(entidade.getEndereco());
    return response;
}
}
