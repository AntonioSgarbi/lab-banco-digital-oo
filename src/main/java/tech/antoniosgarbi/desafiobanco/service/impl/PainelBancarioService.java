package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;
import tech.antoniosgarbi.desafiobanco.service.*;

@Service
public class PainelBancarioService implements IPainelBncarioService {
    private final IContaCorrenteService contaCorrenteService;
    private final IContaPoupancaService contaPoupancaService;
    private final IClienteService clienteService;
    private final ICartaoCreditoService cartaoCreditoService;
    private final ICartaoDebitoService cartaoDebitoService;

    public PainelBancarioService(IContaCorrenteService contaCorrenteService, IContaPoupancaService contaPoupancaService, IClienteService clienteService, ICartaoCreditoService cartaoCreditoService, ICartaoDebitoService cartaoDebitoService) {
        this.contaCorrenteService = contaCorrenteService;
        this.contaPoupancaService = contaPoupancaService;
        this.clienteService = clienteService;
        this.cartaoCreditoService = cartaoCreditoService;
        this.cartaoDebitoService = cartaoDebitoService;
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
    public ClienteResponse cadastrarCliente(ClienteCadastroRequest clienteRequest) {
        return null;
    }

    @Override
    public Page<ClienteResponse> pesquisarClientes(SpecBodyCliente clienteSpecBody, Pageable pageable) {
        return clienteService.pesquisarClientes(clienteSpecBody, pageable);
    }

    @Override
    public Page<CartaoResponse> pesquisarCartoesCredito(SpecBodyCartaoCredito cartaoSpecBody, Pageable pageable) {
        return cartaoCreditoService.pesquisarCartoes(cartaoSpecBody, pageable);
    }

    @Override
    public Page<CartaoResponse> pesquisarCartoesDebito(SpecBodyCartaoDebito cartaoSpecBody, Pageable pageable) {
        return cartaoDebitoService.pesquisarCartoes(cartaoSpecBody, pageable);
    }



}
