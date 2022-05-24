package tech.antoniosgarbi.desafiobanco.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.CartaoResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartao;
import tech.antoniosgarbi.desafiobanco.exception.CartaoException;
import tech.antoniosgarbi.desafiobanco.model.Cartao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.repository.CartaoRepository;
import tech.antoniosgarbi.desafiobanco.service.impl.CartaoService;
import tech.antoniosgarbi.desafiobanco.specification.CartaoSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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
        List<Cartao> listaCartao = List.of(Builder.cartaoDebitoValido(), Builder.cartaoCreditoValido());
        Page<Cartao> pageCartao = new PageImpl<>(listaCartao);

        SpecBodyCartao specBodyCartao = new SpecBodyCartao();

        when(cartaoRepository.findAll((Specification<Cartao>) any(), (Pageable) any())).thenReturn(pageCartao);

        Page<CartaoResponse> resultado = underTest.pesquisarCartoes(specBodyCartao, Pageable.unpaged());

        assertNotNull(resultado.getContent());
        assertNotNull(resultado.getContent().get(0));
        assertNotNull(resultado.getContent().get(1));

        int totalElementosEsperado = 2;
        assertEquals(totalElementosEsperado, resultado.getTotalElements());
    }
}
