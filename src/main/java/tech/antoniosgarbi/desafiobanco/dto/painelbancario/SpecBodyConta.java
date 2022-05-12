package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.antoniosgarbi.desafiobanco.model.Agencia;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;
import tech.antoniosgarbi.desafiobanco.model.enums.ContaTipo;

@Data
@NoArgsConstructor
public class SpecBodyConta {
    private Long numero;

    private ContaTipo contaTipo;

    private Double saldoExato;
    private Double saldoMaximo;
    private Double saldoMinimo;

    private Double limiteMaximo;
    private Double limiteMinimo;
    private Double limiteExato;

    private Agencia agencia;
    private PessoaCliente cliente;
}
