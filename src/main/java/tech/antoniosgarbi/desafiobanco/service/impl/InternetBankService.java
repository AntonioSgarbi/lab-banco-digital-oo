package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.*;
import tech.antoniosgarbi.desafiobanco.service.IInternetBankService;

@Service
public class InternetBankService implements IInternetBankService {

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public ExtratoResponse mostrarExtrato(String mockToken) {
        return null;
    }

    @Override
    public Boolean transferirDinheiro(TransferenciaRequest saqueRequest) {
        return null;
    }

    @Override
    public Boolean solicitarEmprestimo(EmprestimoRequest emprestimoRequest) {
        return null;
    }
}
