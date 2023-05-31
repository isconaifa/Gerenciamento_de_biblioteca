package br.ufmt.web.funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponse {
    private String nome;
    private String cpf;
    private int id;

    
public static FuncionarioResponse from(Funcionario entidade){
    FuncionarioResponse response = new FuncionarioResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setCpf(entidade.getCpf());
    return response;
}
    
}
