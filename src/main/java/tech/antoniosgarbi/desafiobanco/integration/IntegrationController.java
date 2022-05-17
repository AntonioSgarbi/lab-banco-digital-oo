package tech.antoniosgarbi.desafiobanco.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteResponse;

import java.util.List;

@RestController
@RequestMapping("/integration")
public class IntegrationController {
    private final IntegrationService integrationService;

    public IntegrationController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @PostMapping("/cadastro/{quantidade}")
    public ResponseEntity<List<ClienteResponse>> gerarCadastros(@PathVariable Short quantidade) {
        return ResponseEntity.ok(integrationService.gerarCadastros(quantidade));
    }
}
