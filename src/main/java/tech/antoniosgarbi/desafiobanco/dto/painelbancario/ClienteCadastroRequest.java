package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.enums.PessoaRegistroTipo;

import java.time.LocalDate;

@Data
public class ClienteCadastroRequest {
    private Long id;
    private String nome;
    private String documento;
    private PessoaRegistroTipo registroTipo;
    private LocalDate dataNascimento;

}
