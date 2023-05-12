package br.ufmt.web.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "livro")
@SequenceGenerator(name = "seqLivro", sequenceName = "seq_livro_id", allocationSize = 1)
@Getter
@Setter

public class Livro{
    /* private int id;
    private String titulo;
    private int ISBN;
    private int data_publicacao;
 */
    @Id
    @GeneratedValue(generator = "seqLivro", strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editora editor_id;
    private int data_publicacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
    private int data_emprestimo = 0;
    private int data_devolucao = 0;
    private int ISBN;
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