package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.antoniosgarbi.desafiobanco.model.enums.PessoaRegistroTipo;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Pessoa {
    private String nome;
    private String documento;
    private PessoaRegistroTipo registroTipo;
    private LocalDate dataNascimento;
}
