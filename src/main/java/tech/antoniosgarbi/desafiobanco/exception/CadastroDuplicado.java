package tech.antoniosgarbi.desafiobanco.exception;

public class CadastroDuplicado extends RuntimeException {
    public CadastroDuplicado(String mensagem) {
        super(mensagem);
    }
}
