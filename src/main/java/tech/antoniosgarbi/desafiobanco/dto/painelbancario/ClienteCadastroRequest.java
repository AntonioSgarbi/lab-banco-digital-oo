package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.antoniosgarbi.desafiobanco.model.enums.PessoaRegistroTipo;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCadastroRequest {
    private Long id;
    private String nome;
    private String documento;
    private PessoaRegistroTipo registroTipo;
    private LocalDate dataNascimento;
    private String email;
}
