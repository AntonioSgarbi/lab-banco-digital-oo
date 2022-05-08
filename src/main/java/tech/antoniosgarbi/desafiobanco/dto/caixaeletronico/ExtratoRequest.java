package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

public class ExtratoRequest extends RequestCaixaEletronico {
    public ExtratoRequest(String cartaoNumero, String senha) {
        super(cartaoNumero, senha);
    }
}
