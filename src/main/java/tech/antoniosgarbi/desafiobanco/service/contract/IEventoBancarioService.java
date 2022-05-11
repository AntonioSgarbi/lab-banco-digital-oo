package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.evento.Movimentacao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;

@Service
public interface IEventoBancarioService{
    Page<Movimentacao> encontrarTodaMovimentao(Conta conta, Pageable pageable);
}
