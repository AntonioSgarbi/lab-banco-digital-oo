package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;
import tech.antoniosgarbi.desafiobanco.service.contract.ICartaoService;
import tech.antoniosgarbi.desafiobanco.service.contract.IClienteService;
import tech.antoniosgarbi.desafiobanco.service.contract.IContaService;

@Service
public class PainelBancarioService {
    private final IContaService contaService;
    private final IClienteService clienteService;
    private final ICartaoService cartaoService;

    public PainelBancarioService(IContaService contaService,
                                 IClienteService clienteService,
                                 ICartaoService cartaoService
    ) {
        this.contaService = contaService;
        this.clienteService = clienteService;
        this.cartaoService = cartaoService;
    }

    public ClienteCadastroResponse cadastrarCliente(ClienteCadastroRequest clienteRequest) {
        return clienteService.cadastrarClientePainelBancario(clienteRequest);
    }

    public Page<ContaResponse> pesquisarContas(SpecBodyConta contaSpecBody, Pageable pageable) {
        return contaService.pesquisarContas(contaSpecBody, pageable);
    }

    public Page<ClienteResponse> pesquisarClientes(SpecBodyCliente clienteSpecBody, Pageable pageable) {
        return clienteService.pesquisarClientes(clienteSpecBody, pageable);
    }

    public Page<CartaoResponse> pesquisarCartoes(SpecBodyCartao cartaoSpecBody, Pageable pageable) {
        return cartaoService.pesquisarCartoes(cartaoSpecBody, pageable);
    }


}
