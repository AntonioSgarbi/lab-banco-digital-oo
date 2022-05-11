package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferenciaResponse extends InternetBankResponse {
    private String mensagem;
    public TransferenciaResponse(String mensagem) {
        this.mensagem = mensagem;
    }
}
