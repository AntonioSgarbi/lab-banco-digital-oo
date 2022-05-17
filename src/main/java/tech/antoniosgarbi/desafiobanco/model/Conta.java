package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public abstract class Conta {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    protected Long numero;
    protected Double saldo;
    @ManyToOne
    protected Agencia agencia;
    @ManyToOne
    protected Cliente cliente;
    @OneToMany
    protected Set<Cartao> cartoes;
    @OneToMany
    protected Set<EventoBancario> eventosBancarios;
    protected String chavePix;

//    @Override
//    public String toString() {
//        return "Conta{ " +
//                "\nnumero: " + numero +
//                ",\nsaldo: " + saldo +
//                ",\nagencia: " + agencia.getNumero() +
//                ",\ncliente: " + cliente +
//                ",\neventosBancarios: " + eventosBancarios +
//                "\n}";
//    }

}
