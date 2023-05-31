package br.ufmt.web.livro;
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

import br.ufmt.web.autorlivro.AutorLivro;
import br.ufmt.web.editora.Editora;
import br.ufmt.web.generolivro.GeneroLivro;
import br.ufmt.web.reservalivro.ReservaLivro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "livro")
@SequenceGenerator(name = "seqLivro", sequenceName = "seq_livro_id", allocationSize = 1)
@Getter
@Setter

public class Livro{
   /*
    @Id
    @GeneratedValue(generator = "seqLivro", strategy = GenerationType.SEQUENCE)
    private int id;
    private int id;
    private String titulo;
    private int ISBN;
    private int data_publicacao;
    */
    @Id
    @GeneratedValue(generator = "seqLivro", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany
    private List<AutorLivro> autor;

    @OneToMany(mappedBy = "livro")
    private List<GeneroLivro> generos;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editora editor_id;
    private Date data_publicacao;

   // @oneT
   // @JoinColumn(name = "usuario_id")
    //private Usuario usuario;

    @OneToMany(mappedBy = "reservation")
    private List<ReservaLivro> reservas;
 
  
    private String ISBN;
    private String titulo;
  

   @Override
   public int hashCode() {
    final int prime = 10;
    int result = 1;
    result = prime * result + id;
    return result;
   }

   @Override
   public boolean equals(Object obj) {
    if (this == obj)
    return true;
    if (obj == null)
    return false;
    if (getClass() != obj.getClass())
    return false;
    Livro other = (Livro) obj;
    if (id != other.id)
    return false;
    return true;
   }


  //method para cadastrar livros
    /* ublic void cadastrarLivros() {


    }

    public void emprestarLivros() {
    System.out.println("Livro emprestado com sucesso!");

    }

    public void devolver(){
    System.out.println("Livro de devolvido com sucesso!");
    }
 */
 
}