package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class InternetBankRequest {
    protected Long numeroConta;
//    protected ContaTipo tipoConta;
}
