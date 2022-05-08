package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;
import tech.antoniosgarbi.desafiobanco.service.IClienteService;
import tech.antoniosgarbi.desafiobanco.service.IContaCorrenteService;
import tech.antoniosgarbi.desafiobanco.service.IContaPoupancaService;
import tech.antoniosgarbi.desafiobanco.service.IPainelBncarioService;

@Service
public class PainelBancarioService implements IPainelBncarioService {
    private final IContaCorrenteService contaCorrenteService;
    private final IContaPoupancaService contaPoupancaService;
    private final IClienteService clienteService;

    public PainelBancarioService(IContaCorrenteService contaCorrenteService, IContaPoupancaService contaPoupancaService, IClienteService clienteService) {
        this.contaCorrenteService = contaCorrenteService;
        this.contaPoupancaService = contaPoupancaService;
        this.clienteService = clienteService;
    }

    @Override
    public Page<ContaResponse> pesquisarContasCorrente(SpecBodyContaCorrente contasSpecBody, Pageable pageable) {
        return contaCorrenteService.pequisarContasCorrente(contasSpecBody, pageable);
    }

    @Override
    public Page<ContaResponse> pesquisarContasPoupanca(SpecBodyContaPoupanca contaSpecBody, Pageable pageable) {
        return contaPoupancaService.pesquisarContasPoupanca(contaSpecBody, pageable);
    }

    @Override
    public Page<ClienteResponse> pesquisarClientes(SpecBodyCliente clienteSpecBody, Pageable pageable) {
        return clienteService.pesquisarClientes(clienteSpecBody, pageable);
    }

    @Override
    public Page<CartaoResponse> pesquisarCartoes(CartaoSpecBody cartaoSpecBody, Pageable pageable) {
        return null;
    }


}
