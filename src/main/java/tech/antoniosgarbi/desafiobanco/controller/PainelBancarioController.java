package tech.antoniosgarbi.desafiobanco.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;
import tech.antoniosgarbi.desafiobanco.service.impl.PainelBancarioService;

@RestController
@RequestMapping("/painel-bancario")
public class PainelBancarioController {
    private final PainelBancarioService painelBancario;

    public PainelBancarioController(PainelBancarioService painelBancario) {
        this.painelBancario = painelBancario;
    }

    @PutMapping("/conta/query")
    public ResponseEntity<Page<ContaResponse>> pequisarContasCorrente(@RequestBody SpecBodyConta contaSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarContas(contaSpecBody, pageable));
    }

    @PutMapping ("/cliente/query")
    public ResponseEntity<Page<ClienteCadastroResponse>> pesquisarClientes(@RequestBody SpecBodyCliente clienteSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarClientes(clienteSpecBody, pageable));
    }

    @PutMapping("/cartao/query")
    public ResponseEntity<Page<CartaoResponse>> pesquisarCartoes(@RequestBody SpecBodyCartao cartaoSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBancario.pesquisarCartoes(cartaoSpecBody, pageable));
    }

    @PostMapping("/cliente")
    public ResponseEntity<ClienteCadastroResponse> cadastrarCliente(@RequestBody ClienteCadastroRequest clienteRequest) {
        return ResponseEntity.ok(painelBancario.cadastrarCliente(clienteRequest));
    }

    @PutMapping("/cliente")
    public ResponseEntity<ClienteCadastroResponse> editarCliente(@RequestBody ClienteCadastroRequest clienteRequest) {
        return ResponseEntity.ok(painelBancario.cadastrarCliente(clienteRequest));
    }

}
