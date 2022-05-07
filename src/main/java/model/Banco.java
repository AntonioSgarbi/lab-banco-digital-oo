package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Banco {

	private String nome;
	private List<Conta> contas;
}
