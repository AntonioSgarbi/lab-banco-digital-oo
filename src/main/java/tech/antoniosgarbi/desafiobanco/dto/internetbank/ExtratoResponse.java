package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;

import java.util.Set;

@Data
@NoArgsConstructor
public class ExtratoResponse extends InternetBankResponse{

    private Set<EventoBancario> eventos;

    public ExtratoResponse(Set<EventoBancario> eventos) {
        this.eventos = eventos;
    }

    public ExtratoResponse(String mensagem, Set<EventoBancario> eventos) {
        super(mensagem);
        this.eventos = eventos;
    }
}
