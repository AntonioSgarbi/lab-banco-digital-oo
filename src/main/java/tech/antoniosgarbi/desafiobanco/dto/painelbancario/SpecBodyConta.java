package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.Agencia;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;

@Data
public abstract class SpecBodyConta {
    private Long numero;

    protected Double saldoExato;
    protected Double saldoMaximo;
    protected Double saldoMinimo;

    protected Agencia agencia;
    protected PessoaCliente cliente;
}
