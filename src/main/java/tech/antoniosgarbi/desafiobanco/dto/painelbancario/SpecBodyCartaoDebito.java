package tech.antoniosgarbi.desafiobanco.dto.painelbancario;

import lombok.Data;
import tech.antoniosgarbi.desafiobanco.model.enums.CartaoDebitoStatus;

import java.util.List;

@Data
public class SpecBodyCartaoDebito extends SpecBodyCartao {

    private List<CartaoDebitoStatus> status;


}
