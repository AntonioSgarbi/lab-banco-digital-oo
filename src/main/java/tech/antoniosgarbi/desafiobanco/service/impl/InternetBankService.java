package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.*;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;
import tech.antoniosgarbi.desafiobanco.model.enums.EventoTipo;
import tech.antoniosgarbi.desafiobanco.security.services.UserDetailsImpl;
import tech.antoniosgarbi.desafiobanco.service.contract.IClienteService;
import tech.antoniosgarbi.desafiobanco.service.contract.IContaService;
import tech.antoniosgarbi.desafiobanco.service.contract.IInternetBankService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InternetBankService implements IInternetBankService {
    private final IClienteService clienteService;
    private final IContaService contaService;

    public InternetBankService(IClienteService clienteService, IContaService contaService, IContaService icontaService) {
        this.clienteService = clienteService;
        this.contaService = contaService;
    }

    @Override
    public ExtratoResponse mostrarExtrato(UserDetailsImpl userDetails, ExtratoRequest extratoRequest) {
        Cliente clienteLogado = this.buscarPerfil(userDetails);
        Conta conta = this.contaService
                .encontrarContaPorNumeroECliente(extratoRequest.getNumeroConta(), clienteLogado);

        Set<EventoBancario> movimentacoes = conta.getEventosBancarios()
                .stream()
                .filter(x -> x.getTipo() == EventoTipo.MOVIMENTACAO)
                .collect(Collectors.toSet());
        return new ExtratoResponse(null, movimentacoes);
    }

    @Override
    public TransferenciaResponse transferirDinheiro(UserDetailsImpl userDetails, TransferenciaRequest transferenciaRequest) {
        Cliente clienteOrigem = this.buscarPerfil(userDetails);

        return this.contaService.transferirDinheiro(clienteOrigem, transferenciaRequest);
    }

    @Override
    public EmprestimoResponse solicitarEmprestimo(UserDetailsImpl userDetails, EmprestimoRequest emprestimoRequest) {
        //TODO
        return new EmprestimoResponse("Serviço indisponivel no momento");
    }

    private Cliente buscarPerfil(UserDetailsImpl userDetails) {
        return this.clienteService.encontrarPeloUsuario(userDetails.getId());
    }
}
