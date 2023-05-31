package br.ufmt.web.livro;
import lombok.Data;

@Data
public class LivroRequest {
    private String ISBN;
    private String titulo;
    private int id;
}
