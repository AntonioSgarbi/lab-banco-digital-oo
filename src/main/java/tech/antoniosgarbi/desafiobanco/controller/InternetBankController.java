package tech.antoniosgarbi.desafiobanco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tech.antoniosgarbi.desafiobanco.dto.internetbank.*;
import tech.antoniosgarbi.desafiobanco.security.services.UserDetailsImpl;
import tech.antoniosgarbi.desafiobanco.service.contract.IInternetBankService;

@RestController
@RequestMapping("/net-bank")
public class InternetBankController {
    private final IInternetBankService internetBankService;

    public InternetBankController(IInternetBankService internetBankService) {
        this.internetBankService = internetBankService;
    }


    @PutMapping("/extrato")
    public ResponseEntity<InternetBankResponse> mostrarExtrato(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody ExtratoRequest extratoRequest) {
        return ResponseEntity.ok(internetBankService.mostrarExtrato(userDetails, extratoRequest));
    }

    @PostMapping("/transferencia")
    public ResponseEntity<InternetBankResponse> transferirDinheiro(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody TransferenciaRequest saqueRequest) {
        return ResponseEntity
                .accepted().body(internetBankService.transferirDinheiro(userDetails, saqueRequest));
    }

    @PostMapping("/emprestimo")
    public ResponseEntity<InternetBankResponse> solicitarEmprestimo(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody EmprestimoRequest emprestimoRequest) {
        return ResponseEntity.ok(internetBankService.solicitarEmprestimo(userDetails, emprestimoRequest));
    }

}
