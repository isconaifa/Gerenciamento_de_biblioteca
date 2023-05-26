package br.ufmt.web.reservalivro;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.web.livro.Livro;
import br.ufmt.web.reserva.Reserva;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservalivro")
@SequenceGenerator(name = "seqReservaLivro", sequenceName = "seq_reservalivro_id", allocationSize = 1)
@Getter
@Setter

public class ReservaLivro {
//private int id;

//private Reserva reserva;

@Id
@GeneratedValue(generator = "seqReservaLivro", strategy = GenerationType.SEQUENCE)
private int id;

@ManyToOne
   @JoinColumn(name =  "livro")
   private Livro livro;

   
   @ManyToOne
   @JoinColumn(name = "reserva")
   private Reserva reserva;
}
