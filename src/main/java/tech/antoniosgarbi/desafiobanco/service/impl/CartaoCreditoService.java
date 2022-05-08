package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartaoCredito;
import tech.antoniosgarbi.desafiobanco.model.CartaoCredito;
import tech.antoniosgarbi.desafiobanco.repository.CartaoCreditoRepository;
import tech.antoniosgarbi.desafiobanco.service.ICartaoCreditoService;
import tech.antoniosgarbi.desafiobanco.specification.CartaoCreditoSpecification;

@Service
public class CartaoCreditoService implements ICartaoCreditoService {
    private final CartaoCreditoRepository cartaoCreditoRepository;

    public CartaoCreditoService(CartaoCreditoRepository cartaoCreditoRepository) {
        this.cartaoCreditoRepository = cartaoCreditoRepository;
    }

    @Override
    public Page<CartaoResponse> pesquisarCartoes(SpecBodyCartaoCredito cartaoSpecBody, Pageable pageable) {
        CartaoCreditoSpecification specification = new CartaoCreditoSpecification(cartaoSpecBody);
        Page<CartaoCredito> pageModelo = this.cartaoCreditoRepository.findAll(specification, pageable);
        return pageModelo.map(CartaoResponse::new);
    }
}
