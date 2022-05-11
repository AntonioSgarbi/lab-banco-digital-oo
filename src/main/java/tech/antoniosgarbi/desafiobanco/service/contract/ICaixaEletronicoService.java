package tech.antoniosgarbi.desafiobanco.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;


public interface ICaixaEletronicoService {
    Page<ExtratoResponse> imprimirExtrato(String token, ExtratoRequest extratoRequest, Pageable pageable);

    SaqueResponse sacarDinheiro(SaqueRequest requestSaque);

    EmprestimoResponse solicitarEmprestimo(EmprestimoRequest requestEmprestimo);
}
