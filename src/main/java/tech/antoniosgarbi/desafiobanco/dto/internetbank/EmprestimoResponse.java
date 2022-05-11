package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmprestimoResponse extends InternetBankResponse {

    public EmprestimoResponse(String mensagem) {
        super(mensagem);
    }
}
