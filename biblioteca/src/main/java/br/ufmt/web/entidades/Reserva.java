package br.ufmt.web.entidades;
public class Reserva{
    private int id;
    private int data_reserva;
    private int data_devolucao;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getData_reserva() {
        return data_reserva;
    }
    public void setData_reserva(int data_reserva) {
        this.data_reserva = data_reserva;
    }
    public int getData_devolucao() {
        return data_devolucao;
    }
    public void setData_devolucao(int data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}