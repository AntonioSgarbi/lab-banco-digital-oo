package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;
import tech.antoniosgarbi.desafiobanco.exception.OperacaoInvalida;
import tech.antoniosgarbi.desafiobanco.model.ContaPoupanca;
import tech.antoniosgarbi.desafiobanco.model.Movimentacao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.service.contract.ICaixaEletronicoService;
import tech.antoniosgarbi.desafiobanco.service.contract.ICartaoService;
import tech.antoniosgarbi.desafiobanco.service.contract.IContaService;
import tech.antoniosgarbi.desafiobanco.service.contract.IEventoBancarioService;

@Service
public class CaixaEletronicoService implements ICaixaEletronicoService {
    private final ICartaoService cartaoService;
    private final IContaService contaService;
    private final IEventoBancarioService eventoBancarioService;

    public CaixaEletronicoService(ICartaoService cartaoService, IContaService contaService, IEventoBancarioService eventoBancarioService) {
        this.cartaoService = cartaoService;
        this.contaService = contaService;
        this.eventoBancarioService = eventoBancarioService;
    }

    @Override //ready
    public ExtratoResponse imprimirExtrato(ExtratoRequest extratoRequest, Pageable pageable) {
        Conta conta = this.acessarConta(extratoRequest);
        Page<Movimentacao> pageModelo = eventoBancarioService.encontrarTodaMovimentao(conta, pageable);
        Page<MovimentacaoBodyResponse> pageResponse = pageModelo.map(MovimentacaoBodyResponse::new);
        return new ExtratoResponse(conta.getSaldo(), pageResponse);
    }

    @Override
    public SaqueResponse sacarDinheiro(SaqueRequest requestSaque) {
        Conta conta = cartaoService.retornarContaAssociada(requestSaque.getCartaoNumero(), requestSaque.getSenha());
        return this.contaService.sacarDinheiro(conta, requestSaque);
    }

    @Override
    public EmprestimoResponse solicitarEmprestimo(EmprestimoRequest requestEmprestimo) {
        Conta conta = cartaoService
                .retornarContaAssociada(requestEmprestimo.getCartaoNumero(), requestEmprestimo.getSenha());
        return this.contaService.solicitarEmprestimo(conta, requestEmprestimo);
    }

    private Conta acessarConta(RequestCaixaEletronico requestCaixaEletronico) {
        return cartaoService
                .retornarContaAssociada(requestCaixaEletronico.getCartaoNumero(), requestCaixaEletronico.getSenha());
    }

}

