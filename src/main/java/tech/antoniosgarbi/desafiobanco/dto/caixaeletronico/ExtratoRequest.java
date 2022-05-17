package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExtratoRequest extends RequestCaixaEletronico {
    public ExtratoRequest(String cartaoNumero, String senha) {
        super(cartaoNumero, senha);
    }
}
