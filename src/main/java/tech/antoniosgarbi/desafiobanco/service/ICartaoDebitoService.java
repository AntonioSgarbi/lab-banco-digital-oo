package tech.antoniosgarbi.desafiobanco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartaoDebito;

public interface ICartaoDebitoService {
    Page<CartaoResponse> pesquisarCartoes(SpecBodyCartaoDebito cartaoSpecBody, Pageable pageable);
}
