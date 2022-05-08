package tech.antoniosgarbi.desafiobanco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.antoniosgarbi.desafiobanco.dto.caixaeletronico.*;
import tech.antoniosgarbi.desafiobanco.service.ICaixaEletronicoService;

@RestController
@RequestMapping("/caixa-eletronio")
public class CaixaEletronicoController {
    public final ICaixaEletronicoService caixaEletronicoService;

    public CaixaEletronicoController(ICaixaEletronicoService caixaEletronicoService) {
        this.caixaEletronicoService = caixaEletronicoService;
    }

    @GetMapping("/extrato")
    public ResponseEntity<ExtratoResponse> imprimirExtrato(ExtratoRequest requestExtrato) {
        return ResponseEntity.ok(caixaEletronicoService.imprimirExtrato(requestExtrato));
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
