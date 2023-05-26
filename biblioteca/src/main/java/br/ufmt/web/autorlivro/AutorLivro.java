package br.ufmt.web.autorlivro;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import br.ufmt.web.autor.Autor;
import br.ufmt.web.livro.Livro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autorLivro")
@SequenceGenerator(name = "seqAutorLivro", sequenceName = "seq_autorLivro_id", allocationSize = 1)
@Getter
@Setter

public class AutorLivro {

   @Id
@GeneratedValue(generator = "seqReservaLivro", strategy = GenerationType.SEQUENCE)
private int id;

@ManyToOne
   @JoinColumn(name =  "livro")
   private Livro livro;

   @ManyToOne
   @JoinColumn(name = "autor")
   private Autor autor;
}
