package tech.antoniosgarbi.desafiobanco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyContaCorrente;

public interface IContaCorrenteService {
    Page<ContaResponse> pequisarContasCorrente(SpecBodyContaCorrente contasSpecBody, Pageable pageable);
}
