package tech.antoniosgarbi.desafiobanco.dto.internetbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class InternetBankResponse {
    private LocalDateTime momento;
    protected String mensagem;

    public InternetBankResponse(String mensagem) {
        this.momento = LocalDateTime.now();
        this.mensagem = mensagem;
    }

}
