package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;
import tech.antoniosgarbi.desafiobanco.service.ICaixaEletronicoService;
import tech.antoniosgarbi.desafiobanco.service.IClienteService;

@Service
public class CaixaEletronicoService implements ICaixaEletronicoService {
    private final IClienteService clienteService;

    public CaixaEletronicoService(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public ExtratoResponse imprimirExtrato(ExtratoRequest requestExtrato) {
        return null;
    }

    @Override
    public SaqueResponse sacarDinheiro(SaqueRequest requestSaque) {
        return null;
    }

    @Override
    public EmprestimoResponse solicitarEmprestimo(EmprestimoRequest requestEmprestimo) {
        return null;
    }
}
