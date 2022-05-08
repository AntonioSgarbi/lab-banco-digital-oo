package tech.antoniosgarbi.desafiobanco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;

public interface IClienteService {
    public Page<ClienteResponse> pesquisarClientes(SpecBodyCliente specBodyCliente, Pageable pageable);
}
