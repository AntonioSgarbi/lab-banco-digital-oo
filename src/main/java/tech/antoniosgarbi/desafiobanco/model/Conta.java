package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.Set;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Conta {

    protected Long numero;
    protected Double saldo;
    protected Double limiteAprovado;
    @ManyToOne
    protected Agencia agencia;
    @ManyToOne
    protected PessoaCliente cliente;
    @OneToMany
    protected Set<CartaoDebito> cartoesDebito;
    @OneToMany
    protected Set<CartaoCredito> cartoesCredito;
    @OneToMany
    protected Set<EventoBancario> eventosBancarios;

    @Override
    public String toString() {
        return "Conta{ " +
                "\nnumero: " + numero +
                ",\nsaldo: " + saldo +
                ",\nlimiteAprovado: " + limiteAprovado +
                ",\nagencia: " + agencia.getNumero() +
                ",\ncliente: " + cliente +
                ",\neventosBancarios: " + eventosBancarios +
                "\n}";
    }
}
