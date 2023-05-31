package br.ufmt.web.autorlivro;
import br.ufmt.web.autor.Autor;
import br.ufmt.web.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AutorlivroResponse {
    private int id;
    private Livro livro;
    private Autor autor;

public static AutorlivroResponse from(AutorLivro entidade){
    AutorlivroResponse response = new AutorlivroResponse();
    response.setId(entidade.getId());
    response.setLivro(entidade.getLivro());
    response.setAutor(entidade.getAutor());
    return response;
}
    
}
