package br.ufmt.web.usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private int id;
    private String nome;
    private String endereco;
    private String cpf;

    public static UsuarioResponse from(Usuario entidade){
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        response.setEndereco(entidade.getEndereco());
        response.setCpf(entidade.getCpf());
        return response;
    }
    
}
