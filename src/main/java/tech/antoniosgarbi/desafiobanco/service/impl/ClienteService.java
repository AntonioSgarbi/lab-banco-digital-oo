package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;
import tech.antoniosgarbi.desafiobanco.repository.PessoaClienteRepository;
import tech.antoniosgarbi.desafiobanco.service.IClienteService;
import tech.antoniosgarbi.desafiobanco.specification.ClienteSpecification;

@Service
public class ClienteService implements IClienteService {
    private final PessoaClienteRepository pessoaClienteRepository;

    public ClienteService(PessoaClienteRepository pessoaClienteRepository) {
        this.pessoaClienteRepository = pessoaClienteRepository;
    }

    public Page<ClienteResponse> pesquisarClientes(SpecBodyCliente specBodyCliente, Pageable pageable) {
        ClienteSpecification specification = new ClienteSpecification(specBodyCliente);
        Page<PessoaCliente> pageModelo = this.pessoaClienteRepository.findAll(specification, pageable);
        return pageModelo.map(ClienteResponse::new);
    }
}
