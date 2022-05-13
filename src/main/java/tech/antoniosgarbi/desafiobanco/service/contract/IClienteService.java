package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.model.Cliente;

public interface IClienteService {
    public Page<ClienteResponse> pesquisarClientes(SpecBodyCliente specBodyCliente, Pageable pageable);

    ClienteCadastroResponse cadastrarClientePainelBancario(ClienteCadastroRequest clienteRequest);

    Cliente encontrarPeloUsuario(Long id);
}
