package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueResponse;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyConta;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;

import java.util.Optional;

public interface IContaService {

    Double consultarSaldo();

//    TransferenciaResponse transferirDinheiro(Conta contaOrigem, String chavePix, Double valor);

    Conta encontrarContaPorNumeroECliente(Long numero, PessoaCliente cliente);

//    void atualizarSaldo(Double valor, Conta conta);

    Optional<Conta> findContaByChavePix(String chavePix);

    TransferenciaResponse transferirDinheiro(PessoaCliente clienteOrigem, TransferenciaRequest transferenciaRequest);

    Page<ContaResponse> pesquisarContas(SpecBodyConta contaSpecBody, Pageable pageable);

//    List<EventoBancario> visualizarExtrato(Conta conta);

    SaqueResponse sacarDinheiro(Conta conta, SaqueRequest saqueRequest);
}
