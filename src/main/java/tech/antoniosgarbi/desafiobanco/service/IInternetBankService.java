package tech.antoniosgarbi.desafiobanco.service;

import tech.antoniosgarbi.desafiobanco.dto.internetbank.*;

public interface IInternetBankService {

    ExtratoResponse mostrarExtrato();

    Boolean transferirDinheiro(TransferenciaRequest saqueRequest);

    Boolean solicitarEmprestimo(EmprestimoRequest emprestimoRequest);
}
