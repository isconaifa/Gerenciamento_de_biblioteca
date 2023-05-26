package br.ufmt.web.autor;

import lombok.Data;

@Data
public class AutorRequest {
    private String nome;
    private String endereco;
    private String cpf;
}
