package tech.antoniosgarbi.desafiobanco.service;

import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.ExtratoRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaRequest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;
import tech.antoniosgarbi.desafiobanco.model.*;
import tech.antoniosgarbi.desafiobanco.model.enums.EventoTipo;
import tech.antoniosgarbi.desafiobanco.model.enums.PessoaRegistroTipo;
import tech.antoniosgarbi.desafiobanco.security.services.UserDetailsImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Set;

public abstract class Builder {

    public static Long agenciaId = 1L;
    public static int  agenciaNumero = 11111;

    public static Long correnteId= 1000L;
    public static Long correnteNumero = 12345L;
    public static Double correnteLimiteAprovado = 200.00;
    public static Double correnteSaldo = 10.0;
    public static String correnteChavePix = "corrente@pix.com";

    public static Long poupancaId= 1000L;
    public static Long poupancaNumero = 12345L;
    public static Double poupancaSaldo = 5000.0;
    public static String poupancaChavePix = "poupanca@pix.com";

    public static Long clienteId = 360L;
    public static String clienteNome = "Antonio Sgarbi";
    public static String clienteDocumento = "10020030040";

    public static Long cartaoCreditoId = 20L;
    public static Double cartaoCreditoLimite = 2500.0;
    public static String cartaoCreditoSenha = "0000";
    public static String cartaoCreditoNumero = "5555222233331111";
    public static LocalDate cartaoCreditoValidade = LocalDate.of(2026, Month.MAY, 12);

    public static Long cartaoDebitoId = 40L;
    public static String cartaoDebitoSenha = "22222";
    public static String cartaoDebitoNumero = "2222444477771111";
    public static LocalDate cartaoDebitoValidade = LocalDate.of(2026, Month.MAY, 12);

    public static Double transferenciaReqValor = 340.0;
    public static Long transferenciaReqNumero = 55555L;
    private static String transferenciaReqChavePix = "";

    private static Long cadastroRequestId = 250L;
    private static String cadastroRequestNome = "Cliente Preferido";
    private static String cadastroRequestDocumento = "10010010010";
    private static LocalDate cadastroRequestDataNascimento = LocalDate.of(1997, Month.DECEMBER, 3);
    private static PessoaRegistroTipo cadastroRequestRegistroTipo = PessoaRegistroTipo.FISICA;

    private static String userEmail = "user@test.com";
    private static String userLogin = "userLogin";
    private static List<String> userRoles = List.of("CLIENTE");
    private static String userPassword = "password";
    private static String userUsername = "username";

    static Agencia agenciaValida() {
        Agencia agencia = new Agencia();

        agencia.setId(agenciaId);
        agencia.setNumero(agenciaNumero);

        agencia.setContasCorrente(Set.of());
        agencia.setContasPoupanca(Set.of());

        return agencia;
    }

    static Cliente clienteValido() {
        Cliente cliente = new Cliente();

        cliente.setId(clienteId);
        cliente.setNome(clienteNome);
        cliente.setDataNascimento(LocalDate.of(1997, Month.DECEMBER, 3));
        cliente.setDocumento(clienteDocumento);
        cliente.setRegistroTipo(PessoaRegistroTipo.FISICA);

        cliente.setContas(Set.of());
        cliente.setUser(null);

        return cliente;
    }

    static ContaCorrente contaCorrenteValida() {
        ContaCorrente conta = new ContaCorrente();

        conta.setId(correnteId);
        conta.setNumero(correnteNumero);
        conta.setLimiteAprovado(correnteLimiteAprovado);
        conta.setSaldo(correnteSaldo);
        conta.setChavePix(correnteChavePix);

        conta.setAgencia(null);
        conta.setCliente(null);
        conta.setCartoes(Set.of());
        conta.setEventosBancarios(Set.of());

        return conta;
    }

    static ContaPoupanca contaPoupancaValida() {
        ContaPoupanca conta = new ContaPoupanca();

        conta.setNumero(poupancaNumero);
        conta.setId(poupancaId);
        conta.setSaldo(poupancaSaldo);
        conta.setChavePix(poupancaChavePix);

        conta.setAgencia(null);
        conta.setCliente(null);
        conta.setCartoes(Set.of());
        conta.setEventosBancarios(Set.of());

        return conta;
    }

    static CartaoCredito cartaoCreditoValido() {
        CartaoCredito cartao = new CartaoCredito();

        cartao.setId(cartaoCreditoId);
        cartao.setNumero(cartaoCreditoNumero);
        cartao.setLimiteAprovado(cartaoCreditoLimite);
        cartao.setSenha(cartaoCreditoSenha);
        cartao.setValidade(cartaoCreditoValidade);

        cartao.setConta(null);

        return cartao;
    }

    static CartaoDebito cartaoDebitoValido() {
        CartaoDebito cartao = new CartaoDebito();

        cartao.setId(cartaoDebitoId);
        cartao.setNumero(cartaoDebitoNumero);
        cartao.setSenha(cartaoDebitoSenha);
        cartao.setValidade(cartaoDebitoValidade);

        return cartao;
    }

    static TransferenciaRequest transferenciaRequest() {
        TransferenciaRequest request = new TransferenciaRequest();

        request.setChavePix(transferenciaReqChavePix);
        request.setValor(transferenciaReqValor);
        request.setNumeroConta(transferenciaReqNumero);

        return request;
    }

    static ClienteCadastroRequest clienteCadastroRequest() {
        ClienteCadastroRequest request = new ClienteCadastroRequest();

        request.setId(cadastroRequestId);
        request.setNome(cadastroRequestNome);
        request.setDocumento(cadastroRequestDocumento);
        request.setRegistroTipo(cadastroRequestRegistroTipo);
        request.setDataNascimento(cadastroRequestDataNascimento);

        return request;
    }

    static User userValido() {
        User user = new User();

        user.setId(1L);
        user.setAdmin(false);

        user.setEmail(userEmail);
        user.setLogin(userLogin);
        user.setRoles(userRoles);
        user.setPassword(userPassword);
        user.setUsername(userUsername);

        return user;

    }

    static ExtratoRequest extratoRequest() {
        ExtratoRequest request = new ExtratoRequest();

        request.setSenha("senhaExtrato");
        request.setCartaoNumero("cartaoNumero");

        return request;
    }

    static Movimentacao movimentacao() {
        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setId((long) (Math.random() * 100));

        movimentacao.setMomentoRegistrado(LocalDateTime.now());
        movimentacao.setTipo(EventoTipo.MOVIMENTACAO);
        movimentacao.setConta(null);
        movimentacao.setValor((Math.random() * 100));

        return movimentacao;
    }

    static UserDetailsImpl userDetails() {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        userDetails.setId(10L);

        return userDetails;
    }

    static EmprestimoRequest emprestimoRequest() {
        EmprestimoRequest request = new EmprestimoRequest();

        request.setSenha("senha");
        request.setCartaoNumero("cartaoNumero");
        request.setValor(200.0);
        request.setDiaVencimento((short) 10);
        request.setQuantidadeParcelas((short) 2);

        return request;
    }

    static tech.antoniosgarbi.desafiobanco.dto.internetbank.ExtratoRequest extratoRequest1() {
        tech.antoniosgarbi.desafiobanco.dto.internetbank.ExtratoRequest request =
                new tech.antoniosgarbi.desafiobanco.dto.internetbank.ExtratoRequest();

        request.setNumeroConta(11111L);
        return request;
    }

}
