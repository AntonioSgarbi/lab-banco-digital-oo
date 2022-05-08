package tech.antoniosgarbi.desafiobanco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartaoCredito;

public interface ICartaoCreditoService {
    Page<CartaoResponse> pesquisarCartoes(SpecBodyCartaoCredito cartaoSpecBody, Pageable pageable);
}
