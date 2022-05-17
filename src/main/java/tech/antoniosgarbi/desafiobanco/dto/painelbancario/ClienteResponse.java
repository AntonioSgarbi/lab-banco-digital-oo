package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.antoniosgarbi.desafiobanco.model.Cliente;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ClienteResponse extends PainelBancarioResponse {
    private Long id;
    private String nome;
    private String documento;
    private LocalDate dataNascimento;

    public ClienteResponse(Cliente modelo) {
    }

    public ClienteResponse(ClienteCadastroRequest request) {
        this.nome = request.getNome();
        this.dataNascimento = request.getDataNascimento();
        this.documento = request.getDocumento();
    }
}
