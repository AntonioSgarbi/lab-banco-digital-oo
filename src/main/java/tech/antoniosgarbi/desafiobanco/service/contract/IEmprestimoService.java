package tech.antoniosgarbi.desafiobanco.service.contract;

import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoRequest;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;

public interface IEmprestimoService {
    boolean solicitarEmprestimo(ContaCorrente contaValida, EmprestimoRequest requestEmprestimo);
}
