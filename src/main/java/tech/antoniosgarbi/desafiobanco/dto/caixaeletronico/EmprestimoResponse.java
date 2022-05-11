package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmprestimoResponse extends CaixaEletronicoResponse{

    public EmprestimoResponse(String mensagem) {
        super(mensagem);
    }
}
