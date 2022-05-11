package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.antoniosgarbi.desafiobanco.model.enums.ContaTipo;

@Data
@NoArgsConstructor
public abstract class InternetBankRequest {
    protected Long numeroConta;
    protected ContaTipo tipoConta;
}
