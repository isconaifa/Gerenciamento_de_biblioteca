package br.ufmt.web.livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LivroResponse {
    private String ISBN;
    private String titulo;
    private int id;

    public static LivroResponse from(Livro entidade){
        LivroResponse response = new LivroResponse();
        response.setId(entidade.getId());
        response.setISBN(entidade.getISBN());
        response.setTitulo(entidade.getTitulo());
        return response;
    }
    
}
