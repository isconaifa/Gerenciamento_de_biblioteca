package br.ufmt.web.reservalivro;
import br.ufmt.web.livro.Livro;
import br.ufmt.web.reserva.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservalivroResponse {
    private Reserva reserva;
    private Livro livro;
    private int id;

    public static ReservalivroResponse from(ReservaLivro entidade){
        ReservalivroResponse response = new ReservalivroResponse();
        response.setId(entidade.getId());
        response.setLivro(entidade.getLivro());
        response.setReserva(entidade.getReserva());
        return response;
    }
    
}
