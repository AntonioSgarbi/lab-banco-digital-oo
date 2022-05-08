package tech.antoniosgarbi.desafiobanco.service;

import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;

public interface ICaixaEletronicoService {
    ExtratoResponse imprimirExtrato(ExtratoRequest requestExtrato);

    SaqueResponse sacarDinheiro(SaqueRequest requestSaque);

    EmprestimoResponse solicitarEmprestimo(EmprestimoRequest requestEmprestimo);
}
