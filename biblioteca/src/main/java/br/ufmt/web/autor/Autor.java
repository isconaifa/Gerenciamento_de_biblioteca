package br.ufmt.web.autor;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.web.autorlivro.AutorLivro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autor")
@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id", allocationSize = 1)
@Getter
@Setter

public class Autor{
    //private int id;
    private String nome;
    private String endereco;
    private String cpf;

  
    @Id
    @GeneratedValue(generator = "seqAutor", strategy = GenerationType.SEQUENCE)
    private int id;


    @OneToMany(mappedBy = "autor")
    private List<AutorLivro> autor;
}