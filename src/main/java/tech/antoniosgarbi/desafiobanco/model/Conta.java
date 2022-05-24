package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance
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

}
