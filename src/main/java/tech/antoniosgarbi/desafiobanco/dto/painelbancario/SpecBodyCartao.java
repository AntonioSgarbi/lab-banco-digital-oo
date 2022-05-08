package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.ContaPoupanca;

import java.time.LocalDate;
import java.util.List;

@Data
public abstract class SpecBodyCartao {
    protected String numero;

    protected LocalDate validadeExata;
    protected LocalDate validadeMaxima;
    protected LocalDate validadeMinima;

    protected List<ContaCorrente> contasCorrente;
    protected List<ContaPoupanca> contasPoupanca;

}
