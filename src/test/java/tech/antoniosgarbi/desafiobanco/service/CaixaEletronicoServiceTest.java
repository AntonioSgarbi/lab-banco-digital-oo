package tech.antoniosgarbi.desafiobanco.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.model.Movimentacao;
import tech.antoniosgarbi.desafiobanco.service.impl.CaixaEletronicoService;
import tech.antoniosgarbi.desafiobanco.service.impl.CartaoService;
import tech.antoniosgarbi.desafiobanco.service.impl.ContaService;
import tech.antoniosgarbi.desafiobanco.service.impl.EventoBancarioService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CaixaEletronicoServiceTest {
    @Mock private ContaService contaService;
    @Mock private CartaoService cartaoService;
    @Mock private EventoBancarioService eventoBancarioService;

    @InjectMocks private CaixaEletronicoService underTest;

    @Test
    @DisplayName("Deve retornar um ExtratoResponse ao receber ExtratoRequest e Pageable")
    void imprimirExtrato() {
        when(cartaoService.retornarContaAssociada(anyString(), anyString()))
                .thenReturn(Builder.contaPoupancaValida());

        List<Movimentacao> movimentacao =
                List.of(Builder.movimentacao(), Builder.movimentacao(), Builder.movimentacao(), Builder.movimentacao());
        when(eventoBancarioService.encontrarTodaMovimentao(any(),any()))
                .thenReturn(new PageImpl<>(movimentacao));

        ExtratoResponse response = underTest.imprimirExtrato(Builder.extratoRequest(), Pageable.unpaged());

        assertEquals(response.getPagina().getTotalElements(), movimentacao.size());
        assertNotNull(response.getPagina().getContent().get(0));
    }

    @Test
    @DisplayName("Deve retornar um SaqueResponse ao receber SaqueRequest valido")
    void sacarDinheiro() {
        SaqueResponse saqueResponse = new SaqueResponse();
        when(contaService.sacarDinheiro(any(), any()))
                .thenReturn(saqueResponse);

        SaqueResponse response = underTest.sacarDinheiro(new SaqueRequest());

        assertNotNull(response);
        assertEquals(saqueResponse, response);
    }

    @Test
    @DisplayName("Deve retornar um EmprestimoResponse ao receber EmprestimoRequest")
    void solicitarEmprestimo() {
        EmprestimoResponse esperado = new EmprestimoResponse("O valor foi depositado em sua conta!");
        when(cartaoService.retornarContaAssociada(anyString(), anyString()))
                .thenReturn(Builder.contaCorrenteValida());
        when(contaService.solicitarEmprestimo(any(Conta.class), any(EmprestimoRequest.class)))
                .thenReturn(esperado);

        EmprestimoResponse response = underTest.solicitarEmprestimo(Builder.emprestimoRequest());

        assertNotNull(response);
        assertEquals(esperado.getMensagem(), response.getMensagem());
    }

}