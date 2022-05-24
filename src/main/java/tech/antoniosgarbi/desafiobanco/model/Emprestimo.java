package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Emprestimo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ContaCorrente conta;

    private Boolean quitado;

    private Short parcelasRestantes;

    private Short diaVencimento;

    private Double valorParcelas;

    private Short totalParcelas;
}
