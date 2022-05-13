package tech.antoniosgarbi.desafiobanco.exception;

public class CartaoException extends RuntimeException {
    public CartaoException(String mensagem) {
        super(mensagem);
    }
}
