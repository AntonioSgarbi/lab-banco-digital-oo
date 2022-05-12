package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.exception.ClienteNaoEncontrado;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;
import tech.antoniosgarbi.desafiobanco.repository.PessoaClienteRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.IClienteService;
import tech.antoniosgarbi.desafiobanco.specification.ClienteSpecification;

@Service
public class ClienteService implements IClienteService {
    private final PessoaClienteRepository pessoaClienteRepository;

    public ClienteService(PessoaClienteRepository pessoaClienteRepository) {
        this.pessoaClienteRepository = pessoaClienteRepository;
    }

    public Page<ClienteCadastroResponse> pesquisarClientes(SpecBodyCliente specBodyCliente, Pageable pageable) {
        Specification<PessoaCliente> specification = new ClienteSpecification(specBodyCliente);
        Page<PessoaCliente> pageModelo = this.pessoaClienteRepository.findAll(specification, pageable);
        return pageModelo.map(ClienteCadastroResponse::new);
    }

    @Override
    public ClienteCadastroResponse cadastrarClientePainelBancario(ClienteCadastroRequest clienteRequest) {
        return null;
    }

    @Override
    public PessoaCliente encontrarPeloUsuario(Long id) {
        return this.pessoaClienteRepository
                .findPessoaClienteByUserId(id)
                    .orElseThrow(() -> new ClienteNaoEncontrado("Vá até o banco regularizar sua situação"));
    }
}
