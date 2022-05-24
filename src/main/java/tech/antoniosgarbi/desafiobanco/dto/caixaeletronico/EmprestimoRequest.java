package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmprestimoRequest extends RequestCaixaEletronico {
    private Double valor;
    private Short quantidadeParcelas;
    private Short diaVencimento;

    public EmprestimoRequest(String cartaoNumero, String senha, Double valor, Short quantidadeParcelas) {
        super(cartaoNumero, senha);
        this.valor = valor;
        this.quantidadeParcelas = quantidadeParcelas;
    }
}
