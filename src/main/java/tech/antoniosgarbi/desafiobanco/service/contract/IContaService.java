package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoResponse;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.SaqueResponse;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.TransferenciaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ContaResponse;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyConta;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.Conta;

public interface IContaService {

    Conta encontrarContaPorNumeroECliente(Long numero, Cliente cliente);

    Conta findContaByChavePix(String chavePix);

    TransferenciaResponse transferirDinheiro(Cliente clienteOrigem, TransferenciaRequest transferenciaRequest);

    Page<ContaResponse> pesquisarContas(SpecBodyConta contaSpecBody, Pageable pageable);

    SaqueResponse sacarDinheiro(Conta conta, SaqueRequest saqueRequest);

    EmprestimoResponse solicitarEmprestimo(Conta conta, EmprestimoRequest requestEmprestimo);
}
