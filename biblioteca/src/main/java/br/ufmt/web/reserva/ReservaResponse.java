package br.ufmt.web.reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservaResponse {
    private int id;
    private int data_reserva;
    private int data_devolucao;

    public static ReservaResponse from(Reserva entidade){
        ReservaResponse response = new ReservaResponse();
        response.setId(entidade.getId());
        response.setData_reserva(entidade.getData_reserva());
        response.setData_devolucao(entidade.getData_devolucao());
        return response;
    }
    
}
