package tech.antoniosgarbi.desafiobanco.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.ExtratoRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.ExtratoResponse;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.service.impl.ClienteService;
import tech.antoniosgarbi.desafiobanco.service.impl.ContaService;
import tech.antoniosgarbi.desafiobanco.service.impl.InternetBankService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class InternetBankServiceTest {
    @Mock private ClienteService clienteService;
    @Mock private ContaService contaService;

    @InjectMocks private InternetBankService underTest;

    @Test
    @DisplayName("Deve retornar um ExtratoResponde com saldo e eventos ao receber um ExtratoRequest válido")
    void mostrarExtrato0() {
        Conta conta = Builder.contaCorrenteValida();
        Set<EventoBancario> movimentacao =
                Set.of(Builder.movimentacao(),Builder.movimentacao(),Builder.movimentacao(),Builder.movimentacao());
        conta.setEventosBancarios(movimentacao);

        when(contaService.encontrarContaPorNumeroECliente(anyLong(), any()))
                .thenReturn(conta);

        ExtratoResponse esperado = new ExtratoResponse(conta.getSaldo(), movimentacao);

        ExtratoResponse response = underTest.mostrarExtrato(Builder.userDetails(), Builder.extratoRequest1());

        assertEquals(esperado.getEventos(), response.getEventos());
    }

}
