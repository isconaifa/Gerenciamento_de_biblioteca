package br.ufmt.web.usuario;
import lombok.Data;

@Data
public class UsuarioRequest {
        private int id;
        private String nome;
        private String endereco;
        private String cpf;
    
}
