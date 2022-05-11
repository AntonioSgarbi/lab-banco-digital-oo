package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.antoniosgarbi.desafiobanco.model.enums.CartaoDebitoStatus;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartaoDebito extends Cartao {
    private CartaoDebitoStatus status;

}
