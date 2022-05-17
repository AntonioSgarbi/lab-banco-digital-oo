package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;
import tech.antoniosgarbi.desafiobanco.model.Movimentacao;
import tech.antoniosgarbi.desafiobanco.model.Conta;

@Service
public interface IEventoBancarioService{
    Page<Movimentacao> encontrarTodaMovimentao(Conta conta, Pageable pageable);

    void registrarEvento(EventoBancario eventoBancario);
}
