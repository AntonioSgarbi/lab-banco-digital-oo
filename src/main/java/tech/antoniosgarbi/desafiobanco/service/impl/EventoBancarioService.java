package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.evento.Movimentacao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.repository.EventoBancarioRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.IEventoBancarioService;

public class EventoBancarioService implements IEventoBancarioService {
    private final EventoBancarioRepository eventoBancarioRepository;

    public EventoBancarioService(EventoBancarioRepository eventoBancarioRepository) {
        this.eventoBancarioRepository = eventoBancarioRepository;
    }

    @Override
    public Page<Movimentacao> encontrarTodaMovimentao(Conta conta, Pageable pageable) {
        return this.eventoBancarioRepository.findAllByConta(conta, pageable);
    }
}
