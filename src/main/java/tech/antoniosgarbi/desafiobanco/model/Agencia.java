package tech.antoniosgarbi.desafiobanco.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Agencia {
    private int agenciaNumero;
    private List<Cliente> clientes;
}
