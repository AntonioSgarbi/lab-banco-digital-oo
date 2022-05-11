package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaqueRequest extends RequestCaixaEletronico {
    private Double valor;
    public SaqueRequest(String cartaoNumero, String senha, Double valor) {
        super(cartaoNumero, senha);
        this.valor = valor;
    }
}
