package tech.antoniosgarbi.desafiobanco.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;
import tech.antoniosgarbi.desafiobanco.exception.AcessoNegado;
import tech.antoniosgarbi.desafiobanco.service.contract.ICaixaEletronicoService;

@RestController
@RequestMapping("/caixa-eletronico")
public class CaixaEletronicoController {

    @Value("${personal.mock.token}")
    private final String tokenMock = "senha_padrao";
    public final ICaixaEletronicoService caixaEletronicoService;

    public CaixaEletronicoController(ICaixaEletronicoService caixaEletronicoService) {
        this.caixaEletronicoService = caixaEletronicoService;
    }

    @GetMapping("/extrato")
    public ResponseEntity<ExtratoResponse> imprimirExtrato(
            @RequestHeader("token-fake") String token,
            @RequestBody ExtratoRequest extratoRequest,
            Pageable pageable) {
        if(!token.equals(tokenMock)) throw new AcessoNegado();
        return ResponseEntity.ok(caixaEletronicoService.imprimirExtrato(extratoRequest, pageable));
    }

    @PostMapping("/saque")
    public ResponseEntity<SaqueResponse> sacarDinheiro(@RequestBody SaqueRequest requestSaque){
        return ResponseEntity.ok(caixaEletronicoService.sacarDinheiro(requestSaque));
    }

    @PostMapping("emprestimo")
    public ResponseEntity<EmprestimoResponse> solicitarEmprestimo(@RequestBody EmprestimoRequest requestEmprestimo) {
        return ResponseEntity.ok(caixaEletronicoService.solicitarEmprestimo(requestEmprestimo));
    }
}
