package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;

public interface IClienteService {
    public Page<ClienteCadastroResponse> pesquisarClientes(SpecBodyCliente specBodyCliente, Pageable pageable);

    ClienteCadastroResponse cadastrarClientePainelBancario(ClienteCadastroRequest clienteRequest);

    PessoaCliente encontrarPeloUsuario(Long id);
}
