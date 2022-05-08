package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

public class SaqueRequest extends RequestCaixaEletronico {
    public SaqueRequest(String cartaoNumero, String senha) {
        super(cartaoNumero, senha);
    }
}
