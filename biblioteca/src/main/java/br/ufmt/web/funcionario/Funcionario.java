package br.ufmt.web.funcionario;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.web.reserva.Reserva;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "autor")
@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id", allocationSize = 1)
@Getter
@Setter

public class Funcionario{
    //private int id;
    //private String nome;
    //private String cpf;

    @Id
    @GeneratedValue(generator = "seqAutor", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany
    private List<Reserva> reserva;

    private String nome;
    private String cpf;
}