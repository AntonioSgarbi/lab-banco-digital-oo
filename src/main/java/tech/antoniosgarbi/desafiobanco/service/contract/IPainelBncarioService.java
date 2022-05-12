package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;

public interface IPainelBncarioService {
    Page<ContaResponse> pesquisarContas(SpecBodyConta contasSpecBody, Pageable pageable);

    Page<ClienteCadastroResponse> pesquisarClientes(SpecBodyCliente clienteSpecBody, Pageable pageable);

    Page<CartaoResponse> pesquisarCartoes(SpecBodyCartao cartaoSpecBody, Pageable pageable);

    ClienteCadastroResponse cadastrarCliente(ClienteCadastroRequest clienteRequest);
}
