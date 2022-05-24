package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Pageable;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;


public interface ICaixaEletronicoService {
    ExtratoResponse imprimirExtrato(ExtratoRequest extratoRequest, Pageable pageable);

    SaqueResponse sacarDinheiro(SaqueRequest requestSaque);

    EmprestimoResponse solicitarEmprestimo(EmprestimoRequest requestEmprestimo);
}
