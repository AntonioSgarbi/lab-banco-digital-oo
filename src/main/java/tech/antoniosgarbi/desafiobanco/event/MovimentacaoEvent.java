package tech.antoniosgarbi.desafiobanco.event;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.Movimentacao;

@Data
public class MovimentacaoEvent {
    private Movimentacao movimentacao;

    public MovimentacaoEvent(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }
}
