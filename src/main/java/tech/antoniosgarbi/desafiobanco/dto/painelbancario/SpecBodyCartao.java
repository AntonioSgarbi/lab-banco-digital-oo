package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.ContaPoupanca;
import tech.antoniosgarbi.desafiobanco.model.enums.CartaoCreditoStatus;
import tech.antoniosgarbi.desafiobanco.model.enums.CartaoDebitoStatus;

import java.time.LocalDate;
import java.util.List;

@Data
public abstract class SpecBodyCartao {
    private String numero;

    private LocalDate validadeExata;
    private LocalDate validadeMaxima;
    private LocalDate validadeMinima;

    private List<ContaCorrente> contasCorrente;
    private List<ContaPoupanca> contasPoupanca;

    private List<CartaoDebitoStatus> statusDebito;

    private List<CartaoCreditoStatus> statusCredito;

    private Double limiteAprovadoExato;
    private Double limiteAprovadoMinimo;
    private Double limiteAprovadoMaximo;

}
