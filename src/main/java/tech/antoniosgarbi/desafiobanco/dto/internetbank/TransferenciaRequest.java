package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferenciaRequest extends InternetBankRequest {
    private String chavePix;
    private Double valor;
}
