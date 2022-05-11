package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public abstract class Cartao {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    protected String senha;
    protected LocalDate validade;
    protected String numero;
    @ManyToOne
    protected Conta conta;
}
