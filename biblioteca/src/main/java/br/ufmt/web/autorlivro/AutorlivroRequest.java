package br.ufmt.web.autorlivro;
import br.ufmt.web.autor.Autor;
import br.ufmt.web.livro.Livro;
import lombok.Data;

@Data
public class AutorlivroRequest {
    private int livroId;
    private int autorId;
}
