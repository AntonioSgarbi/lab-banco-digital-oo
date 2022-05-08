package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.enums.CartaoCreditoStatus;

import java.util.List;


@Data
public class SpecBodyCartaoCredito extends SpecBodyCartao{

    private List<CartaoCreditoStatus> status;

    private Double limiteAprovadoExato;
    private Double limiteAprovadoMinimo;
    private Double limiteAprovadoMaximo;

}
