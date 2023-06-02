package br.ufmt.web.reservalivro;
import br.ufmt.web.livro.Livro;
import br.ufmt.web.reserva.Reserva;
import lombok.Data;

@Data
public class ReservalivroRequest {
    private int ReservaId;
    private int  livroId;
    private int id;
}
