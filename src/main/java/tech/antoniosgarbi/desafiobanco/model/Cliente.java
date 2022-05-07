package tech.antoniosgarbi.desafiobanco.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {
	private String nome;
	private Agencia agencia;

}
