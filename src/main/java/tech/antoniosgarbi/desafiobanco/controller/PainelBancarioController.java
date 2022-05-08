package tech.antoniosgarbi.desafiobanco.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;
import tech.antoniosgarbi.desafiobanco.service.IPainelBncarioService;

@RestController
@RequestMapping("/painel-bancario")
public class PainelBancarioController {
    private final IPainelBncarioService painelBncario;

    public PainelBancarioController(IPainelBncarioService painelBncario) {
        this.painelBncario = painelBncario;
    }

    @PutMapping("/conta-corrente/query")
    public ResponseEntity<Page<ContaResponse>> pequisarContasCorrente(@RequestBody SpecBodyContaCorrente contaSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBncario.pesquisarContasCorrente(contaSpecBody, pageable));
    }

    @PutMapping("/conta-poupanca/query")
    public ResponseEntity<Page<ContaResponse>> pesquisarContasPoupanca(@RequestBody SpecBodyContaPoupanca contaSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBncario.pesquisarContasPoupanca(contaSpecBody, pageable));
    }

    @PutMapping ("/cliente")
    public ResponseEntity<Page<ClienteResponse>> vizualizarClientes(@RequestBody SpecBodyCliente clienteSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBncario.pesquisarClientes(clienteSpecBody, pageable));
    }

    @PutMapping("/cartao")
    public ResponseEntity<Page<CartaoResponse>> vizualizarCartoes(@RequestBody CartaoSpecBody cartaoSpecBody, Pageable pageable) {
        return ResponseEntity.ok(painelBncario.pesquisarCartoes(cartaoSpecBody, pageable));
    }

}
