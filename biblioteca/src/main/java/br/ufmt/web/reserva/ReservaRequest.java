package br.ufmt.web.reserva;
import lombok.Data;

@Data
public class ReservaRequest {
        private int id;
        private int data_reserva;
        private int data_devolucao;
}
