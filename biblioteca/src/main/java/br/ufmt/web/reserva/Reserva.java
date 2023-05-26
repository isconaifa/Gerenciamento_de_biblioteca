package br.ufmt.web.reserva;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.web.funcionario.Funcionario;
import br.ufmt.web.reservalivro.ReservaLivro;
import br.ufmt.web.usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reserva")
@SequenceGenerator(name = "seqReserva", sequenceName = "seq_reserva_id", allocationSize = 1)
@Getter
@Setter


public class Reserva{
    //private int id;
    private int data_reserva;
    private int data_devolucao;
  
    @Id
    @GeneratedValue(generator = "seqReserva", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaLivro> reserva;

   @ManyToOne
   @JoinColumn(name =  "funcionario_id")
   private Funcionario funcionario;


   @ManyToOne
   @JoinColumn(name = "usuario_id")
   private Usuario usuario;

}