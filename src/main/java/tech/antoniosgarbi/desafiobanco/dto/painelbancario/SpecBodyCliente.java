package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.enums.PessoaRegistroTipo;

import java.time.LocalDate;
import java.util.List;

@Data
public class SpecBodyCliente {
    private String nome;
    private String documento;
    private PessoaRegistroTipo pessoaRegistroTipo;

    private LocalDate dataNascimentoExata;
    private LocalDate dataNascimentoMinima;
    private LocalDate dataNascimentoMaxima;

    private List<Long> idsContaCorrente;
    private List<Long> idsContaPoupanca;
}
