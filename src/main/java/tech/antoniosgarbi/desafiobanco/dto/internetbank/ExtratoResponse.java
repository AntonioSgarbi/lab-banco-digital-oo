package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;

import java.util.Set;

@Data
@NoArgsConstructor
public class ExtratoResponse extends InternetBankResponse{

    private Double saldo;
    private Set<EventoBancario> eventos;

    public ExtratoResponse(Double saldo, Set<EventoBancario> eventos) {
        this.saldo = saldo;
        this.eventos = eventos;
    }

    public ExtratoResponse(String mensagem, Double saldo, Set<EventoBancario> eventos) {
        super(mensagem);
        this.saldo = saldo;
        this.eventos = eventos;
    }
}
