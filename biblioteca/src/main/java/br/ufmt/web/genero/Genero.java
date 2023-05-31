package br.ufmt.web.genero;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.web.generolivro.GeneroLivro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genero")
@SequenceGenerator(name = "seqGenero", sequenceName = "seq_genero_id", allocationSize = 1)
@Getter
@Setter

public class Genero{
    //private int id;
    private String nome;

    @Id
    @GeneratedValue(generator = "seqGenero", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "genero")
    private List<GeneroLivro> genero;
}