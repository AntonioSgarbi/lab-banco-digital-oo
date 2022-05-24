package tech.antoniosgarbi.desafiobanco.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyConta;
import tech.antoniosgarbi.desafiobanco.exception.ContaNaoEncontrada;
import tech.antoniosgarbi.desafiobanco.exception.SaldoInsuficiente;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.repository.ContaRepository;
import tech.antoniosgarbi.desafiobanco.service.impl.ContaService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ContaServiceTest {
    @Mock
    private ContaRepository contaRepository;
    @InjectMocks
    private ContaService underTest;

   @BeforeEach
   void setUp() {
   }

   @Test
   @DisplayName("Deve retornar um conta ao receber numero e cliente validos")
    void encontrarContaPorNumeroECliente0() {
       when(contaRepository.findContaByNumeroAndCliente(anyLong(), any()))
               .thenReturn(Optional.of(Builder.contaCorrenteValida()));

       Conta conta = underTest.encontrarContaPorNumeroECliente(1L, Builder.clienteValido());

       assertNotNull(conta);
       assertEquals(Builder.correnteId, conta.getId());
       assertEquals(Builder.correnteNumero, conta.getNumero());
       assertEquals(Builder.correnteChavePix, conta.getChavePix());
   }

   @Test
   @DisplayName("Deve lançar um ContaNaoEncontrada em caso de Optional vazio")
    void encontrarContaPorNumeroECliente1() {
       when(contaRepository.findContaByNumeroAndCliente(anyLong(), any()))
               .thenReturn(Optional.empty());

       var exception = assertThrows(ContaNaoEncontrada.class,
               () -> underTest.encontrarContaPorNumeroECliente(1L, Builder.clienteValido()));

       String mensagemEsperada = "Dados inconsistentes, compareça em uma agência para regularizar";
       assertEquals(mensagemEsperada, exception.getMessage());
   }

   @Test
   @DisplayName("Deve retornar uma Conta ao receber uma chave pix existente")
    void findContaByChavePix0(){
       when(contaRepository.findByChavePix(anyString()))
               .thenReturn(Optional.of(Builder.contaPoupancaValida()));

       Conta conta = underTest.findContaByChavePix("chave_pix");

       assertNotNull(conta);
       assertEquals(Builder.poupancaId, conta.getId());
       assertEquals(Builder.poupancaNumero, conta.getNumero());
       assertEquals(Builder.poupancaChavePix, conta.getChavePix());
   }

   @Test
   @DisplayName("Deve lançar um ContaNaoEncontrada em caso de Optional vazio")
    void findContaByChavePix1(){
       when(contaRepository.findByChavePix(anyString()))
               .thenReturn(Optional.empty());

       var exception =
               assertThrows(ContaNaoEncontrada.class, () -> underTest.findContaByChavePix("chave pix invalida"));

       String mensagemEsperada = "A chave Pix não existe!";
       assertEquals(mensagemEsperada, exception.getMessage());
   }

   @Test
   @DisplayName("Deve retornar um TransferenciaResponse ao receber Cliente e TransferenciaRequest com valor disponivel")
    void transferirDinheiro0() {
       Conta contaOrigem = Builder.contaCorrenteValida();
       Double saldoOrigem = 300.0;
       contaOrigem.setSaldo(saldoOrigem);
       when(contaRepository.findContaByNumeroAndCliente(anyLong(), any()))
               .thenReturn(Optional.of(contaOrigem));

       when(contaRepository.findByChavePix(anyString())).thenReturn(Optional.of(Builder.contaPoupancaValida()));

       TransferenciaRequest request = Builder.transferenciaRequest();
       request.setValor(200.0);

       TransferenciaResponse response =
               underTest.transferirDinheiro(Builder.clienteValido(), Objects.requireNonNull(request));

       assertEquals("Valor transferido com sucesso!", response.getMensagem());
   }

   @Test
   @DisplayName("Deve lançar SaldoInsuficiente ao receber valor de Transferência maior que o saldo")
    void transferirDinheiro1() {
       Conta contaOrigem = Builder.contaCorrenteValida();
       Double saldoOrigem = 300.0;
       contaOrigem.setSaldo(saldoOrigem);

       when(contaRepository.findContaByNumeroAndCliente(anyLong(), any())).thenReturn(Optional.of(contaOrigem));
       when(contaRepository.findByChavePix(anyString())).thenReturn(Optional.of(Builder.contaPoupancaValida()));

       TransferenciaRequest request = Builder.transferenciaRequest();
       request.setValor(400.0);

      assertTrue(request.getValor() > saldoOrigem);

      var exception =
               assertThrows(
                       SaldoInsuficiente.class,
                       () -> underTest.transferirDinheiro(Builder.clienteValido(), Objects.requireNonNull(request)));

       String mensagemEsperada = "Você não possui saldo suficiente para esta operação, saldo disponível: " + contaOrigem.getSaldo();
       assertEquals(mensagemEsperada, exception.getMessage());
   }

   @Test
   @DisplayName("Deve retornar uma Page<ContaResponse> ao receber um SpecBodyConta e Pageable")
   void pesquisarContas0() {
      List<Conta> listaModel = List.of(Builder.contaCorrenteValida(), Builder.contaPoupancaValida());
      Page<Conta> pageModel = new PageImpl<>(listaModel);

      SpecBodyConta specBodyConta = new SpecBodyConta();

      when(contaRepository.findAll((Specification<Conta>) any(), (Pageable) any())).thenReturn(pageModel);

      Page<ContaResponse> resultado = underTest.pesquisarContas(specBodyConta, Pageable.unpaged());

      assertNotNull(resultado.getContent());
      assertNotNull(resultado.getContent().get(0));
      assertNotNull(resultado.getContent().get(1));

      int totalElementosEsperado = 2;
      assertEquals(totalElementosEsperado, resultado.getTotalElements());
   }

}
