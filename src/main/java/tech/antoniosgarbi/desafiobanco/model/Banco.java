package tech.antoniosgarbi.desafiobanco.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Banco {
	private String nome;
	private List<Agencia> agencias;
}
