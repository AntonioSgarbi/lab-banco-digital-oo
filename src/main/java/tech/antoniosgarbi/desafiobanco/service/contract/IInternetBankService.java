package tech.antoniosgarbi.desafiobanco.service.contract;

import tech.antoniosgarbi.desafiobanco.dto.internetbank.ExtratoRequest;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.*;
import tech.antoniosgarbi.desafiobanco.security.services.UserDetailsImpl;

public interface IInternetBankService {

    ExtratoResponse mostrarExtrato(UserDetailsImpl userDetails, ExtratoRequest extratoRequest);

    TransferenciaResponse transferirDinheiro(UserDetailsImpl userDetails, TransferenciaRequest saqueRequest);

    EmprestimoResponse solicitarEmprestimo(UserDetailsImpl userDetails, EmprestimoRequest emprestimoRequest);
}
