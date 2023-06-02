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
    private String livro;
    private String autor;

public static AutorlivroResponse from(AutorLivro entidade){
    AutorlivroResponse response = new AutorlivroResponse();
    response.setId(entidade.getId());
    response.setLivro(entidade.getLivro().getTitulo());
    response.setAutor(entidade.getAutor().getNome());
    return response;
}
    
}
