package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.antoniosgarbi.desafiobanco.model.enums.EventoTipo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Inheritance
@Entity
@Getter
@Setter
@NoArgsConstructor
public class EventoBancario {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime momentoRegistrado;

    private EventoTipo tipo;
    @ManyToOne
    private Conta conta;

    public EventoBancario(Long id) {
        this.momentoRegistrado = LocalDateTime.now();
        this.id = id;
    }

}