package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;

public interface IPainelBncarioService {
    Page<ContaResponse> pesquisarContasCorrente(SpecBodyContaCorrente contasSpecBody, Pageable pageable);

    Page<ClienteCadastroResponse> pesquisarClientes(SpecBodyCliente clienteSpecBody, Pageable pageable);

    Page<CartaoResponse> pesquisarCartoesCredito(SpecBodyCartaoCredito cartaoSpecBody, Pageable pageable);

    Page<CartaoResponse> pesquisarCartoesDebito(SpecBodyCartaoDebito cartaoSpecBody, Pageable pageable);

    Page<ContaResponse> pesquisarContasPoupanca(SpecBodyContaPoupanca contaSpecBody, Pageable pageable);

    ClienteCadastroResponse cadastrarCliente(ClienteCadastroRequest clienteRequest);
}
