package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.antoniosgarbi.desafiobanco.model.enums.CartaoCreditoStatus;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartaoCredito extends Cartao {
    private Double limiteAprovado;
    private CartaoCreditoStatus status;

}