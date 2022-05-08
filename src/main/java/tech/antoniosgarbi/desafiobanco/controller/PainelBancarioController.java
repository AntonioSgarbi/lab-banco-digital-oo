package tech.antoniosgarbi.desafiobanco.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;
import tech.antoniosgarbi.desafiobanco.service.IPainelBncarioService;

@RestController
@RequestMapping("/painel-bancario")
public class PainelBancarioController {
    private final IPainelBncarioService painelBancario;

    public PainelBancarioController(IPainelBncarioService painelBncario) {
        this.painelBancario = painelBncario;
    }

    @PutMapping("/conta-corrente/query")
    public ResponseEntity<Page<ContaResponse>> pequisarContasCorrente(@RequestBody SpecBodyContaCorrente contaSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarContasCorrente(contaSpecBody, pageable));
    }

    @PutMapping("/conta-poupanca/query")
    public ResponseEntity<Page<ContaResponse>> pesquisarContasPoupanca(@RequestBody SpecBodyContaPoupanca contaSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarContasPoupanca(contaSpecBody, pageable));
    }

    @PutMapping ("/cliente/query")
    public ResponseEntity<Page<ClienteResponse>> pesquisarClientes(@RequestBody SpecBodyCliente clienteSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarClientes(clienteSpecBody, pageable));
    }

    @PutMapping("/cartao-credito/query")
    public ResponseEntity<Page<CartaoResponse>> pesquisarCartoesCredito(@RequestBody SpecBodyCartaoCredito cartaoSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarCartoesCredito(cartaoSpecBody, pageable));
    }

    @PutMapping("/cartao-debito/query")
    public ResponseEntity<Page<CartaoResponse>> pesquisarCartoesDebito(@RequestBody SpecBodyCartaoDebito cartaoSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarCartoesDebito(cartaoSpecBody, pageable));
    }

    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteCadastroRequest clienteRequest) {
        return ResponseEntity.ok(painelBancario.cadastrarCliente(clienteRequest));
    }

}
