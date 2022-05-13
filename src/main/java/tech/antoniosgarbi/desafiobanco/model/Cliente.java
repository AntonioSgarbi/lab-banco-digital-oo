package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Pessoa {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private Set<Conta> contas;

    public Cliente(ClienteCadastroRequest dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.registroTipo = dto.getRegistroTipo();
        this.documento = dto.getDocumento();
    }
}
