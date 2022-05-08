package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Cartao {
    protected String senha;
    protected LocalDate validade;
    protected String numero;
    protected Long contaId;
    @ManyToOne
    protected ContaPoupanca contaPoupanca;
    @ManyToOne
    protected ContaCorrente contaCorrente;


}
