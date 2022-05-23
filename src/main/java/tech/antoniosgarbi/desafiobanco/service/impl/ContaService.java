package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoResponse;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueResponse;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyConta;
import tech.antoniosgarbi.desafiobanco.exception.ContaNaoEncontrada;
import tech.antoniosgarbi.desafiobanco.exception.LimiteInsuficiente;
import tech.antoniosgarbi.desafiobanco.exception.OperacaoInvalida;
import tech.antoniosgarbi.desafiobanco.exception.SaldoInsuficiente;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.ContaPoupanca;
import tech.antoniosgarbi.desafiobanco.repository.ContaRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.IContaService;
import tech.antoniosgarbi.desafiobanco.service.contract.IEmprestimoService;
import tech.antoniosgarbi.desafiobanco.specification.ContaSpecification;

import javax.transaction.Transactional;

@Service
public class ContaService implements IContaService {
    private final IEmprestimoService emprestimoService;
    private final ContaRepository contaRepository;


    public ContaService(IEmprestimoService emprestimoService, ContaRepository contaRepository) {
        this.emprestimoService = emprestimoService;
        this.contaRepository = contaRepository;
    }

    @Override
    public Conta encontrarContaPorNumeroECliente(Long numero, Cliente cliente) {
        return this.contaRepository
                .findContaByNumeroAndCliente(numero, cliente)
                .orElseThrow(
                        () -> new ContaNaoEncontrada(
                                "Dados inconsistentes, compareça em uma agência para regularizar"));
    }

    @Override
    public Conta findContaByChavePix(String chavePix) {
        return this.contaRepository.findByChavePix(chavePix)
                .orElseThrow(() -> new ContaNaoEncontrada("A chave Pix não existe!"));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public TransferenciaResponse transferirDinheiro(Cliente clienteOrigem, TransferenciaRequest transferenciaRequest) {
        Conta contaOrigem = this.encontrarContaPorNumeroECliente(transferenciaRequest.getNumeroConta(), clienteOrigem);
        Double saldoContaOrigem = contaOrigem.getSaldo();
        Double valorTransferido = transferenciaRequest.getValor();

        Conta contaDestino = this.findContaByChavePix(transferenciaRequest.getChavePix());

        if (valorTransferido > saldoContaOrigem)
            throw new SaldoInsuficiente(
                    "Você não possui saldo suficiente para esta operação," +
                            " saldo disponível: " + saldoContaOrigem);
        contaOrigem.setSaldo(saldoContaOrigem - valorTransferido);
        contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferido);

        this.contaRepository.save(contaOrigem);
        this.contaRepository.save(contaDestino);

        return new TransferenciaResponse("Valor transferido com sucesso!");
    }

    @Override
    public Page<ContaResponse> pesquisarContas(SpecBodyConta contaSpecBody, Pageable pageable) {
        Specification<Conta> specification = new ContaSpecification(contaSpecBody);
        Page<Conta> pageModelo = this.contaRepository.findAll(specification, pageable);
        return pageModelo.map(ContaResponse::new);
    }

    @Override
    public SaqueResponse sacarDinheiro(Conta conta, SaqueRequest saqueRequest) {
        if (conta instanceof ContaCorrente contaCorrente)
            return this.sacarDinheiroContaCorrente(contaCorrente, saqueRequest);

        return this.sacarDinheiroContaPoupanca((ContaPoupanca) conta, saqueRequest);
    }

    @Override
    public EmprestimoResponse solicitarEmprestimo(Conta conta, EmprestimoRequest requestEmprestimo) {
        if (conta instanceof ContaPoupanca contaPoupanca)
            throw new OperacaoInvalida("Apenas contas corrente tem acesso a esse serviço!");
        ContaCorrente contaValida = (ContaCorrente) conta;
        Double valorRequisitado = requestEmprestimo.getValor();
        if (valorRequisitado > contaValida.getLimiteAprovado())
            throw new LimiteInsuficiente("Seu limite aprovado não cobre essa solicitação, valor máximo: " + contaValida.getLimiteAprovado());
        emprestimoService.solicitarEmprestimo(contaValida, requestEmprestimo);

        contaValida.setSaldo(contaValida.getSaldo() + requestEmprestimo.getValor());
        contaRepository.save(contaValida);
        return new EmprestimoResponse("O valor foi depositado em sua conta!");
    }

    private SaqueResponse sacarDinheiroContaCorrente(ContaCorrente conta, SaqueRequest saqueRequest) {
        Double saldoDisponivel = conta.getSaldo();
        Double limiteDisponivel = conta.getLimiteAprovado();
        Double valorSaque = saqueRequest.getValor();

        if (valorSaque > (saldoDisponivel + limiteDisponivel))
            throw new SaldoInsuficiente("Você não possui fundos para completar essa operação!");
        if (saldoDisponivel > valorSaque) {
            conta.setSaldo(saldoDisponivel - valorSaque);
            this.contaRepository.save(conta);
            return new SaqueResponse("Seu dinheiro está sendo contado e será entregue em poucos instantes");
        }
        //TODO valorSaque < (saldoDisponivel + limiteAprovado)
        return new SaqueResponse(
                "Serviço indisponível no momento, tente mais tarde ou implemente essa função");
    }

    private SaqueResponse sacarDinheiroContaPoupanca(ContaPoupanca conta, SaqueRequest saqueRequest) {
        Double saldoDisponivel = conta.getSaldo();
        Double valorSaque = saqueRequest.getValor();
        if (saldoDisponivel > valorSaque) {
            conta.setSaldo(saldoDisponivel - valorSaque);
            this.contaRepository.save(conta);
            return new SaqueResponse("Seu dinheiro está sendo contado e será entregue em poucos instantes");
        }
        throw new SaldoInsuficiente("Você não possui fundos para completar essa operação!");
    }

}