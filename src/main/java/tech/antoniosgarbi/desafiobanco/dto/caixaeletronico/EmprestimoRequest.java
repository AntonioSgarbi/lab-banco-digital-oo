package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

public class EmprestimoRequest extends RequestCaixaEletronico {
    public EmprestimoRequest(String cartaoNumero, String senha) {
        super(cartaoNumero, senha);
    }
}
