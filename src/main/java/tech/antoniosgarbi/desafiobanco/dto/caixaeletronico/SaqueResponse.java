package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaqueResponse extends CaixaEletronicoResponse {

    public SaqueResponse(String mensagem) {
        super(mensagem);
    }
}
