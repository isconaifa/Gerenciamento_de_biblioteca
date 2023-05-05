package br.ufmt.web.entidades;
public class Livro{
    private int id;
    private String titulo;
    private int ISBN;
    private int data_publicacao;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }
    public int getData_publicacao() {
        return data_publicacao;
    }
    public void setData_publicacao(int data_publicacao) {
        this.data_publicacao = data_publicacao;
    }


  
}