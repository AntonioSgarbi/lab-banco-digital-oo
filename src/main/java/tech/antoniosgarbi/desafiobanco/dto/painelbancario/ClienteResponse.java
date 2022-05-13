package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.antoniosgarbi.desafiobanco.model.Cliente;

@Data
@NoArgsConstructor
public class ClienteResponse extends PainelBancarioResponse {

    public ClienteResponse(Cliente modelo) {
    }

}
