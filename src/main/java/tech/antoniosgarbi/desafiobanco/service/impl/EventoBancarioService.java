package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;
import tech.antoniosgarbi.desafiobanco.model.Movimentacao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.repository.EventoBancarioRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.IEventoBancarioService;

@Service
public class EventoBancarioService implements IEventoBancarioService {
    private final EventoBancarioRepository eventoBancarioRepository;

    public EventoBancarioService(EventoBancarioRepository eventoBancarioRepository) {
        this.eventoBancarioRepository = eventoBancarioRepository;
    }

    @Override
    public Page<Movimentacao> encontrarTodaMovimentao(Conta conta, Pageable pageable) {
        return this.eventoBancarioRepository.findAllByConta(conta, pageable);
    }

    @Override
    public void registrarEvento(EventoBancario eventoBancario) {
        System.out.println("evento registrado");
    }
}
