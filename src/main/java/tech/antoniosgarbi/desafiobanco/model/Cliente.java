package tech.antoniosgarbi.desafiobanco.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Pessoa {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

}
