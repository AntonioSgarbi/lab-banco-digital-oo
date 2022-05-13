package tech.antoniosgarbi.desafiobanco.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tech.antoniosgarbi.desafiobanco.exception.CartaoException;
import tech.antoniosgarbi.desafiobanco.model.Cartao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.repository.CartaoRepository;
import tech.antoniosgarbi.desafiobanco.service.impl.CartaoService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CartaoServiceTest {
    @Mock
    private CartaoRepository cartaoRepository;
    @InjectMocks
    private CartaoService underTest;

    @Test
    @DisplayName("deve retornar uma Conta ao receber um numero de cartão e senha correspondentes")
    void retornarContaAssociada0() {
        Cartao cartao = Builder.cartaoDebitoValido();
        Conta conta = Builder.contaCorrenteValida();
        cartao.setConta(conta);

        when(cartaoRepository.findByNumero(anyString())).thenReturn(Optional.of(cartao));

        Conta retorno = underTest.retornarContaAssociada(cartao.getNumero(), cartao.getSenha());

        assertNotNull(retorno);
        assertEquals(conta, retorno);
    }

    @Test
    @DisplayName("Deve lançar uma CartaoException em caso de Optional vazio")
    void retornarContaAssociada1() {
        when(cartaoRepository.findByNumero(anyString())).thenReturn(Optional.empty());

        CartaoException exception = assertThrows(
                CartaoException.class,
                () -> underTest
                        .retornarContaAssociada("cartao.getNumero()", "cartao.getSenha()"));

        String mensagemEsperada ="Falha na operação, procure uma agẽncia para regularizar sua situação";
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar uma CartaoExeption ao receber a senha errada")
    void retornarContaAssociada2() {
        Cartao cartao = Builder.cartaoDebitoValido();

        when(cartaoRepository.findByNumero(anyString())).thenReturn(Optional.of(cartao));

        var exception = assertThrows(CartaoException.class,
                () -> underTest.retornarContaAssociada(cartao.getNumero(), "senha_diferente"));
        String mensagemEsperada = "Senha incorreta, tente novamente";
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    @DisplayName("Deve retornar uma Page<CartaoResponse> ao receber um SpecBodyCartao e Pageable")
    void pesquisarCartoes0() {
        //TODO
    }
}
