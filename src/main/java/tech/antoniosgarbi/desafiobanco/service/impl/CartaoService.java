package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.service.contract.ICartaoService;

@Service
public class CartaoService implements ICartaoService {

    @Override
    public Page<CartaoResponse> pesquisarCartoes(SpecBodyCartao cartaoSpecBody, Pageable pageable) {
        return null;
    }

    @Override
    public Conta retornarContaAssociada(String cartaoNumero) {
        return null;
    }


}
