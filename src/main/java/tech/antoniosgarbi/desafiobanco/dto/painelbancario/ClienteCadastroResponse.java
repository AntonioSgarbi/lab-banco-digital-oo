package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteCadastroResponse extends PainelBancarioResponse {
    String mensagem;

    public ClienteCadastroResponse(String mensagem) {
        this.mensagem = mensagem;
    }

}
