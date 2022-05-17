package tech.antoniosgarbi.desafiobanco.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "nome-api", url = "https://gerador-nomes.herokuapp.com")
public interface NomeFeign {

    @GetMapping("/nome/aleatorio")
    public ResponseEntity<List<String>> solicitarUmNomeCompleto();

    @GetMapping("/nomes/{quantidade}")
    public ResponseEntity<List<String>> solicitarNomes(@PathVariable byte quantidade);
}
