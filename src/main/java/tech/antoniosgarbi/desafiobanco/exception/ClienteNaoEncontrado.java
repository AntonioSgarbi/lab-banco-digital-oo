package tech.antoniosgarbi.desafiobanco.exception;

public class ClienteNaoEncontrado extends RuntimeException {
    public ClienteNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
