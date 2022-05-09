package tech.antoniosgarbi.desafiobanco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.*;
import tech.antoniosgarbi.desafiobanco.service.IInternetBankService;

@RestController
@RequestMapping("/net-bank")
public class InternetBankController {
    private final IInternetBankService internetBankService;

    public InternetBankController(IInternetBankService internetBankService) {
        this.internetBankService = internetBankService;
    }

    @GetMapping("/extrato")
    public ResponseEntity<ExtratoResponse> mostrarExtrato() {
        return ResponseEntity.ok(internetBankService.mostrarExtrato());
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Boolean> transferirDinheiro(
            @RequestBody TransferenciaRequest saqueRequest) {
        return ResponseEntity.ok(internetBankService.transferirDinheiro(saqueRequest));
    }

    @PostMapping("/emprestimo")
    public ResponseEntity<Boolean> solicitarEmprestimo(
            @RequestParam("authorization") String mockToken,
            @RequestBody EmprestimoRequest emprestimoRequest) {
        return ResponseEntity.ok(internetBankService.solicitarEmprestimo(emprestimoRequest));
    }

}
