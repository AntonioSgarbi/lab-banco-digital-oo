package tech.antoniosgarbi.desafiobanco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyContaPoupanca;

public interface IContaPoupancaService {
    Page<ContaResponse> pesquisarContasPoupanca(SpecBodyContaPoupanca contaSpecBody, Pageable pageable);
}
