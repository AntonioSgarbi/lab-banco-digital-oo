package tech.antoniosgarbi.desafiobanco.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Banco {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;
	@OneToMany
	private List<Agencia> agencias;

}
