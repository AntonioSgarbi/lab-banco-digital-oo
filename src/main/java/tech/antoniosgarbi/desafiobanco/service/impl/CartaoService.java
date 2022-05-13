package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartao;
import tech.antoniosgarbi.desafiobanco.exception.CartaoException;
import tech.antoniosgarbi.desafiobanco.model.Cartao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.repository.CartaoRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.ICartaoService;
import tech.antoniosgarbi.desafiobanco.specification.CartaoSpecification;

@Service
public class CartaoService implements ICartaoService {
    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public Page<CartaoResponse> pesquisarCartoes(SpecBodyCartao cartaoSpecBody, Pageable pageable) {
        Specification<Cartao> specfication = new CartaoSpecification(cartaoSpecBody);
        Page<Cartao> pageModelo = this.cartaoRepository.findAll(specfication, pageable);
        return pageModelo.map(CartaoResponse::new);
    }

    @Override
    public Conta retornarContaAssociada(String cartaoNumero, String cartaoSenha) {
        Cartao cartao = this.cartaoRepository.findByNumero(cartaoNumero).orElseThrow(
                () -> new CartaoException("Falha na operação, procure uma agẽncia para regularizar sua situação"));
        if (!cartao.getSenha().equals(cartaoSenha))
            throw new CartaoException("Senha incorreta, tente novamente");
        return cartao.getConta();
    }


}