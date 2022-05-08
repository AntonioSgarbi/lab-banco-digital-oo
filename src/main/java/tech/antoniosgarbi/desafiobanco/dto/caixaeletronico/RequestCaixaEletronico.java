package tech.antoniosgarbi.desafiobanco.dto.caixaeletronico;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class RequestCaixaEletronico {
    public LocalDateTime localDateTime;
    public String cartaoNumero;
    public String senha;

    public RequestCaixaEletronico(String cartaoNumero, String senha) {
        this.localDateTime =LocalDateTime.now();
        this.cartaoNumero = cartaoNumero;
        this.senha = senha;
    }


}
