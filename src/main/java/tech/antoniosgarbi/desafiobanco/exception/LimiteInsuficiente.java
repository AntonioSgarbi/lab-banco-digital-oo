package tech.antoniosgarbi.desafiobanco.exception;

public class LimiteInsuficiente extends RuntimeException {
    public LimiteInsuficiente(String mensagem) {
        super(mensagem);
    }
}
