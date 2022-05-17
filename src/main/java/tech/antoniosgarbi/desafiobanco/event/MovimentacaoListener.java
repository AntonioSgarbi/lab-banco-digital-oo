package tech.antoniosgarbi.desafiobanco.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import tech.antoniosgarbi.desafiobanco.service.contract.IEventoBancarioService;

@Component
public class MovimentacaoListener {
    private final IEventoBancarioService eventoBancarioService;

    public MovimentacaoListener(IEventoBancarioService eventoBancarioService) {
        this.eventoBancarioService = eventoBancarioService;
    }

    @EventListener
    @Async
    public void registrarEvento(MovimentacaoEvent event) {
        this.eventoBancarioService.registrarEvento(event.getMovimentacao());
    }
}
