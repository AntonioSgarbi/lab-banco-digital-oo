package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.antoniosgarbi.desafiobanco.model.enums.PessoaRegistroTipo;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Pessoa {
    protected String nome;
    protected String documento;
    protected PessoaRegistroTipo registroTipo;
    protected LocalDate dataNascimento;
    @OneToOne
    protected User user;
}
