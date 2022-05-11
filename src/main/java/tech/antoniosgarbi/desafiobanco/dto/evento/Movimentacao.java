package tech.antoniosgarbi.desafiobanco.dto.evento;

import tech.antoniosgarbi.desafiobanco.model.EventoBancario;

import javax.persistence.Entity;

@Entity
public class Movimentacao extends EventoBancario {
    private Double valor;
}
