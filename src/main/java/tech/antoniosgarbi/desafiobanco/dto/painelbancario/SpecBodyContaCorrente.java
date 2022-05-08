package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpecBodyContaCorrente extends SpecBodyConta {
    private Double limiteMaximo;
    private Double limiteMinimo;
    private Double limiteExato;
}
