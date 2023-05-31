package br.ufmt.web.generolivro;
import br.ufmt.web.genero.Genero;
import br.ufmt.web.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerolivroResponse {
    private Genero genero;
    private Livro livro;
    private int id;

    public static GenerolivroResponse from(GeneroLivro entidade){
        GenerolivroResponse response = new GenerolivroResponse();
        response.setId(entidade.getId());
        response.setGenero(entidade.getGenero());
        response.setLivro(entidade.getLivro());
        return response;
    }
    
}
