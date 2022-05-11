package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartao;
import tech.antoniosgarbi.desafiobanco.model.Conta;

public interface ICartaoService {
    Page<CartaoResponse> pesquisarCartoes(SpecBodyCartao cartaoSpecBody, Pageable pageable);

    Conta retornarContaAssociada(String cartaoNumero);
}
