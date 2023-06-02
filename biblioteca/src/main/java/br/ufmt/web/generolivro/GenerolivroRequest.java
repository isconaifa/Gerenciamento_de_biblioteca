package br.ufmt.web.generolivro;
import br.ufmt.web.genero.Genero;
import br.ufmt.web.livro.Livro;
import lombok.Data;

@Data
public class GenerolivroRequest {
    private int  generoId;
    private int  livroId;
}
