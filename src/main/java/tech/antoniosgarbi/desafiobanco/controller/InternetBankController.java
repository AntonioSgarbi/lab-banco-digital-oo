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

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginApp(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(internetBankService.login(loginRequest));
    }

    @GetMapping("/extrato")
    public ResponseEntity<ExtratoResponse> mostrarExtrato(@RequestParam("authorization") String mockToken) {
        return ResponseEntity.ok(internetBankService.mostrarExtrato(mockToken));
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Boolean> transferirDinheiro(
            @RequestParam("authorization") String mockToken,
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
