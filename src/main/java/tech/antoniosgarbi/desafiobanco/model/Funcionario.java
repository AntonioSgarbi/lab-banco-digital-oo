package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Pessoa {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

}
