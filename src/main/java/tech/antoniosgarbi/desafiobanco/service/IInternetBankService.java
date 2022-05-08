package tech.antoniosgarbi.desafiobanco.service;

import tech.antoniosgarbi.desafiobanco.dto.internetbank.*;

public interface IInternetBankService {
    LoginResponse login(LoginRequest loginRequest);

    ExtratoResponse mostrarExtrato(String mockToken);

    Boolean transferirDinheiro(TransferenciaRequest saqueRequest);

    Boolean solicitarEmprestimo(EmprestimoRequest emprestimoRequest);
}
