package br.ufmt.web.editora;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditoraResponse {
    private int id;
    private String nome;
    private String obra;
    private String telefone;

public static EditoraResponse from(Editora entidade){
    EditoraResponse response = new EditoraResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setObra(entidade.getObra());
    response.setTelefone(entidade.getTelefone());
    return response;
}
    
}
