package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;
import tech.antoniosgarbi.desafiobanco.repository.ContaCorrenteRepository;
import tech.antoniosgarbi.desafiobanco.service.IContaCorrenteService;
import tech.antoniosgarbi.desafiobanco.specification.ContaCorrenteSpecification;

@Service
public class ContaCorrenteService implements IContaCorrenteService {
    private final ContaCorrenteRepository contaCorrenteRepository;

    public ContaCorrenteService(ContaCorrenteRepository contaCorrenteRepository) {
        this.contaCorrenteRepository = contaCorrenteRepository;
    }

    @Override
    public Page<ContaResponse> pequisarContasCorrente(SpecBodyContaCorrente contasSpecBody, Pageable pageable) {
        ContaCorrenteSpecification specification = new ContaCorrenteSpecification(contasSpecBody);
        Page<ContaCorrente> pageModelo = contaCorrenteRepository.findAll(specification, pageable);
        return pageModelo.map(ContaResponse::new);
    }

}
