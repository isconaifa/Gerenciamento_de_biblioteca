package br.ufmt.web.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autor")
@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id", allocationSize = 1)
@Getter
@Setter

public class Autor{
    private int id;
    private String nome;
    private String endereco;
    private String cpf;

    @Id
    @GeneratedValue(generator = "seq_autor_id", strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    @ManyToMany(mappedBy = "autor")
    @JoinColumn(name = "id_livro")
     private Livro livro;
    }
    


}