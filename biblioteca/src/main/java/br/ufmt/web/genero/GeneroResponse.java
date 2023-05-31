package br.ufmt.web.genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GeneroResponse {
    private String nome;
    private int id;

    public static GeneroResponse from(Genero entidade){
        GeneroResponse response = new GeneroResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        return response;
    }
        
    
}
