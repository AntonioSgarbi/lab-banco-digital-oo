package tech.antoniosgarbi.desafiobanco.service.impl;

import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoRequest;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.EmprestimoResponse;
import tech.antoniosgarbi.desafiobanco.exception.LimiteInsuficiente;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.Emprestimo;
import tech.antoniosgarbi.desafiobanco.repository.EmprestimoRepository;
import tech.antoniosgarbi.desafiobanco.service.contract.IEmprestimoService;

import java.util.List;

@Service
public class EmprestimoService implements IEmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public boolean solicitarEmprestimo(ContaCorrente contaValida, EmprestimoRequest requestEmprestimo) {
        List<Emprestimo> emprestimosExistentes = this.emprestimoRepository.findAllByConta(contaValida);

        Double valorTotalBloqueado = 0.0;
        if(contaValida.getSaldo() < 0)
            valorTotalBloqueado += Math.abs(contaValida.getSaldo());

        for (Emprestimo emprestimo : emprestimosExistentes) {
            if(emprestimo.getQuitado()) continue;
            valorTotalBloqueado += (emprestimo.getParcelasRestantes() * emprestimo.getValorParcelas());
        }

        if((valorTotalBloqueado + requestEmprestimo.getValor()) > contaValida.getLimiteAprovado()) {
            Double limiteDisponivel = contaValida.getLimiteAprovado() - valorTotalBloqueado;
            throw new LimiteInsuficiente(
                    "Você não possui limite para esta operação, limite disponivel: " + limiteDisponivel);
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setValorParcelas(requestEmprestimo.getValor());
        emprestimo.setConta(contaValida);
        emprestimo.setDiaVencimento(requestEmprestimo.getDiaVencimento());
        emprestimo.setQuitado(false);
        emprestimo.setParcelasRestantes(requestEmprestimo.getQuantidadeParcelas());
        emprestimo.setTotalParcelas(requestEmprestimo.getQuantidadeParcelas());

        this.emprestimoRepository.save(emprestimo);
        return true;
    }
}
