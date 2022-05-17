package tech.antoniosgarbi.desafiobanco.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroResponse;
import tech.antoniosgarbi.desafiobanco.service.impl.ClienteService;
import tech.antoniosgarbi.desafiobanco.service.impl.PainelBancarioService;

@SpringBootTest
public class PainelBancarioServiceTest {
    @Mock private ClienteService clienteService;

    @InjectMocks private PainelBancarioService underTest;

    @Test
    void cadastrarCliente0() {
        ClienteCadastroRequest request = Builder.clienteCadastroRequest();

        ClienteCadastroResponse response = underTest.cadastrarCliente(request);
    }





}
