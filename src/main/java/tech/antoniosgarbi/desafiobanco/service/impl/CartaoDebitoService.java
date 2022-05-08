package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartaoDebito;
import tech.antoniosgarbi.desafiobanco.model.CartaoDebito;
import tech.antoniosgarbi.desafiobanco.repository.CartaoDebitoRepository;
import tech.antoniosgarbi.desafiobanco.service.ICartaoDebitoService;
import tech.antoniosgarbi.desafiobanco.specification.CartaoDebitoSpecification;

@Service
public class CartaoDebitoService implements ICartaoDebitoService {
    private final CartaoDebitoRepository cartaoDebitoRepository;

    public CartaoDebitoService(CartaoDebitoRepository cartaoDebitoRepository) {
        this.cartaoDebitoRepository = cartaoDebitoRepository;
    }

    @Override
    public Page<CartaoResponse> pesquisarCartoes(SpecBodyCartaoDebito cartaoSpecBody, Pageable pageable) {
        CartaoDebitoSpecification specification = new CartaoDebitoSpecification(cartaoSpecBody);
        Page<CartaoDebito> pageModelo = this.cartaoDebitoRepository.findAll(specification, pageable);
        return pageModelo.map(CartaoResponse::new);
    }
}
