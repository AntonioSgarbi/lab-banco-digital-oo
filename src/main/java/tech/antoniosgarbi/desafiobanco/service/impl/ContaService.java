package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueResponse;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.ExtratoResponse;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyConta;
import tech.antoniosgarbi.desafiobanco.exception.ContaNaoEncontrada;
import tech.antoniosgarbi.desafiobanco.exception.SaldoInsuficiente;
import tech.antoniosgarbi.desafiobanco.model.*;
import tech.antoniosgarbi.desafiobanco.repository.ContaRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.IContaService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService implements IContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Double consultarSaldo() {
        // TODO
        return 0.0;
    }

    @Override
    public Conta encontrarContaPorNumeroECliente(Long numero, PessoaCliente cliente) {
        return this.contaRepository
                .findContaByNumeroAndCliente(numero, cliente)
                .orElseThrow(
                        () -> new ContaNaoEncontrada(
                                "Dados inconsistentes, compareça em uma agência para regularizar"));
    }

    @Override
    public Optional<Conta> findContaByChavePix(String chavePix) {
        return Optional.empty();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public TransferenciaResponse transferirDinheiro(PessoaCliente clienteOrigem, TransferenciaRequest transferenciaRequest) {
        Conta contaOrigem = this.encontrarContaPorNumeroECliente(transferenciaRequest.getNumeroConta(), clienteOrigem);
        Double saldoContaOrigem = contaOrigem.getSaldo();
        Double valorTransferido = transferenciaRequest.getValor();
        Conta contaDestino = this.contaRepository.findByChavePix(transferenciaRequest.getChavePix())
                .orElseThrow(() -> new ContaNaoEncontrada("A chave Pix não existe!"));

        if(valorTransferido > saldoContaOrigem)
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
        return null;
    }

    @Override
    public SaqueResponse sacarDinheiro(Conta conta, SaqueRequest saqueRequest) {
        Class classeHerdeira = verificarTipoConta(conta);
        if(classeHerdeira.getTypeName().equals("ContaCorrente")) {
            System.out.println("ContaCorrente");
            return this.sacarDinheiroContaCorrente((ContaCorrente) conta, saqueRequest);
        }
        return this.sacarDinheiroContaPoupanca((ContaPoupanca) conta, saqueRequest);
    }

    private SaqueResponse sacarDinheiroContaCorrente(ContaCorrente conta, SaqueRequest saqueRequest) {
        Double saldoDisponivel = conta.getSaldo();
        Double limiteDisponivel = conta.getLimiteAprovado();
        Double valorSaque = saqueRequest.getValor();
        if(valorSaque > (saldoDisponivel + limiteDisponivel))
            throw new SaldoInsuficiente("Você não possui fundos para completar essa operação!");
        if(saldoDisponivel > valorSaque) {
            conta.setSaldo(saldoDisponivel - valorSaque);
            this.contaRepository.save(conta);
            return new SaqueResponse("Seu dinheiro está sendo contado e será entregue em poucos instantes");
        }
        //TODO
        return new SaqueResponse(
                "Serviço indisponível no momento, tente mais tarde ou implemente essa função");
    }

    private SaqueResponse sacarDinheiroContaPoupanca(ContaPoupanca conta, SaqueRequest saqueRequest) {
        //TODO
        return new SaqueResponse(
                "Apeanas saque de conta corrente está disponivel, use outra conta ou implemente a função");
    }

    private Class verificarTipoConta(Conta conta) {
        return conta.getClass();
    }

}
