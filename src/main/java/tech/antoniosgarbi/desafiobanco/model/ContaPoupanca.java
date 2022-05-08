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
public class ContaPoupanca extends Conta {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Cartao cartao;

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato model.Conta Poupan�a ===");
		super.imprimirInfosComuns();
	}
}