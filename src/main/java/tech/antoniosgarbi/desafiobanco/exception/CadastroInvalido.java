package tech.antoniosgarbi.desafiobanco.exception;

public class CadastroInvalido extends RuntimeException {
    public CadastroInvalido(String mensagem) {
        super(mensagem);
    }
}
