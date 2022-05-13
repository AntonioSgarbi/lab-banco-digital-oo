package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.exception.CadastroDuplicado;
import tech.antoniosgarbi.desafiobanco.exception.CadastroInvalido;
import tech.antoniosgarbi.desafiobanco.exception.ClienteNaoEncontrado;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.repository.ClienteRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.IClienteService;
import tech.antoniosgarbi.desafiobanco.specification.ClienteSpecification;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {
    private final ClienteRepository pessoaClienteRepository;

    public ClienteService(ClienteRepository pessoaClienteRepository) {
        this.pessoaClienteRepository = pessoaClienteRepository;
    }

    public Page<ClienteResponse> pesquisarClientes(SpecBodyCliente specBodyCliente, Pageable pageable) {
        Specification<Cliente> specification = new ClienteSpecification(specBodyCliente);
        Page<Cliente> pageModelo = this.pessoaClienteRepository.findAll(specification, pageable);
        return pageModelo.map(ClienteResponse::new);
    }

    @Override
    public ClienteCadastroResponse cadastrarClientePainelBancario(ClienteCadastroRequest clienteRequest) {
        Cliente cliente = new Cliente(clienteRequest);
        Period period = Period.between(clienteRequest.getDataNascimento(), LocalDate.now());

        if(period.getYears() < 18) throw new CadastroInvalido("Menores de idade não podem ser cadastrados");

        Optional<Cliente> optional = this.pessoaClienteRepository.findByDocumento(cliente.getDocumento());
        if(optional.isPresent())
            throw new CadastroDuplicado("Essa pessoa já possui um cadastro de cliente, edite seu registro");

        this.pessoaClienteRepository.save(cliente);

        //TODO: cadastrar usuário

        return new ClienteCadastroResponse("Cadastro realizado");
    }

    @Override
    public Cliente encontrarPeloUsuario(Long id) {
        return this.pessoaClienteRepository
                .findClienteByUserId(id)
                    .orElseThrow(() -> new ClienteNaoEncontrado("Vá até o banco regularizar sua situação"));
    }

}
