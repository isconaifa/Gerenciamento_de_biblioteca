package br.ufmt.web.generolivro;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.web.genero.Genero;
import br.ufmt.web.livro.Livro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "generolivro")
@SequenceGenerator(name = "seqGeneroLivro", sequenceName = "generolivro", allocationSize = 1)
@Getter
@Setter

public class GenerLivro {
    //private int id;
   @Id
   @GeneratedValue(generator = "seqGeneroLivro", strategy = GenerationType.SEQUENCE)
   private int id;
   
   @ManyToOne
      @JoinColumn(name =  "livro")
      private Livro livro;

    @ManyToOne
      @JoinColumn(name = "genero")
      private Genero genero;

}
