package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
public class ExtratoResponse {
    private Double saldo;
    private Page<MovimentacaoBodyResponse> pagina;

    public ExtratoResponse(Double saldo, Page<MovimentacaoBodyResponse>pagina) {
        this.saldo = saldo;
        this.pagina = pagina;
    }
}
