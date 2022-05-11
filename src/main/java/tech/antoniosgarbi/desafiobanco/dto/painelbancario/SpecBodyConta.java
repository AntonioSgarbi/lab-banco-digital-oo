package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.Agencia;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;
import tech.antoniosgarbi.desafiobanco.model.enums.ContaTipo;

@Data
public abstract class SpecBodyConta {
    private Long numero;

    protected ContaTipo contaTipo;

    protected Double saldoExato;
    protected Double saldoMaximo;
    protected Double saldoMinimo;

    protected Agencia agencia;
    protected PessoaCliente cliente;
}
