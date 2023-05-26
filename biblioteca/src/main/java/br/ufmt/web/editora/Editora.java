package br.ufmt.web.editora;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;

import br.ufmt.web.livro.Livro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "editora")
@SequenceGenerator(name = "seqEditora", sequenceName = "seq_editora_id", allocationSize = 1)
@Getter
@Setter

public class Editora{
    //private int id;
    private String nome;
    private String obra;
    private String telefone;

    @Id
    @GeneratedValue(generator = "seqEditora", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "livro")
    private  List<Livro> livros;
}
