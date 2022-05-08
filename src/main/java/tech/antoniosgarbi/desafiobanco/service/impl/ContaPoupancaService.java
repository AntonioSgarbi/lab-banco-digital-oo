package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyContaPoupanca;
import tech.antoniosgarbi.desafiobanco.model.ContaPoupanca;
import tech.antoniosgarbi.desafiobanco.repository.ContaPoupancaRepository;
import tech.antoniosgarbi.desafiobanco.service.IContaPoupancaService;
import tech.antoniosgarbi.desafiobanco.specification.ContaPoupancaSpecification;

@Service
public class ContaPoupancaService implements IContaPoupancaService {
    private final ContaPoupancaRepository contaPoupancaRepository;

    public ContaPoupancaService(ContaPoupancaRepository contaPoupancaRepository) {
        this.contaPoupancaRepository = contaPoupancaRepository;
    }


    @Override
    public Page<ContaResponse> pesquisarContasPoupanca(SpecBodyContaPoupanca contaSpecBody, Pageable pageable) {
        ContaPoupancaSpecification specification = new ContaPoupancaSpecification(contaSpecBody);
        Page<ContaPoupanca> pageModelo = this.contaPoupancaRepository.findAll(specification, pageable);
        return pageModelo.map(ContaResponse::new);
    }
}
