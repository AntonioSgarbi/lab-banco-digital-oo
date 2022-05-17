package tech.antoniosgarbi.desafiobanco.exception;

public class OperacaoInvalida extends RuntimeException {
    public OperacaoInvalida(String mensagem) {
        super(mensagem);
    }
}
