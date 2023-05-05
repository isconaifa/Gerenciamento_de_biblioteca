package br.ufmt.web.entidades;
public class Editora{
    private int id;
    private String nome;
    private String obra;
    private String telefone;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getObra() {
        return obra;
    }
    public void setObra(String obra) {
        this.obra = obra;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
