package tech.antoniosgarbi.desafiobanco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContaCorrente extends Conta {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	private List<Cartao> cartoes;
	private Double saldo;
	private Double limiteAprovado;

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato model.Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}