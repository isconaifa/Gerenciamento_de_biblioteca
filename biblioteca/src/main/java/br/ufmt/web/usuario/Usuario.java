package br.ufmt.web.usuario;
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
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", allocationSize = 1)
@Getter
@Setter
public class Usuario{
    //private int id;
    private String nome;
    private String endereco;
    private String cpf;

    
    @Id
    @GeneratedValue(generator = "seqUsuario", strategy = GenerationType.SEQUENCE)
    private int id;


    @OneToMany(mappedBy = "usuario")
    private  List<Reserva> reservas;
    //private List<AutorLivro> autor;
}