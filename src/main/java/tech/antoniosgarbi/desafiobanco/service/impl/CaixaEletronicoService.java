package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;
import tech.antoniosgarbi.desafiobanco.dto.evento.Movimentacao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.service.contract.*;

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
    public Page<ExtratoResponse> imprimirExtrato(String token, ExtratoRequest extratoRequest, Pageable pageable) {
        Conta conta = this.acessarConta(extratoRequest);
        Page<Movimentacao> eventosBancarios = eventoBancarioService.encontrarTodaMovimentao(conta, pageable);
        return  eventosBancarios.map(ExtratoResponse::new);
    }

    @Override
    public SaqueResponse sacarDinheiro(SaqueRequest requestSaque) {
        Conta conta = cartaoService.retornarContaAssociada(requestSaque.cartaoNumero);
        return this.contaService.sacarDinheiro(conta, requestSaque);
    }

    @Override
    public EmprestimoResponse solicitarEmprestimo(EmprestimoRequest requestEmprestimo) {
        // TODO
        return new EmprestimoResponse("Este serviço se encontra indisponível no momento");
    }

    private Conta acessarConta(RequestCaixaEletronico requestCaixaEletronico) {
        return cartaoService.retornarContaAssociada(requestCaixaEletronico.cartaoNumero);
    }

}

