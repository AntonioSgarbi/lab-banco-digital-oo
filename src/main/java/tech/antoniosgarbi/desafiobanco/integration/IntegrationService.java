package tech.antoniosgarbi.desafiobanco.integration;

import org.springframework.stereotype.Service;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteCadastroRequest;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.ClienteResponse;
import tech.antoniosgarbi.desafiobanco.model.enums.PessoaRegistroTipo;
import tech.antoniosgarbi.desafiobanco.service.contract.IClienteService;
import tech.antoniosgarbi.desafiobanco.service.contract.IContaService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class IntegrationService {
    private final NomeFeign nomeFeign;
    private final IContaService contaService;
    private final IClienteService clienteService;

    public IntegrationService(NomeFeign nomeFeign, IContaService contaService, IClienteService clienteService) {
        this.nomeFeign = nomeFeign;
        this.contaService = contaService;
        this.clienteService = clienteService;
    }

    public List<ClienteResponse> gerarCadastros(short quantidade) {
        Random gerador = new Random();

        List<ClienteResponse> clientesGerados = new LinkedList<>();

        for(int i=0; i>quantidade; i++){
            ClienteCadastroRequest request = new ClienteCadastroRequest();

            int ano = gerador.nextInt(1950, 2003);
            int mes = gerador.nextInt(1,12);
            int dia = gerador.nextInt(1,28);

            LocalDate dataGerada = LocalDate.of(ano, mes, dia);
            request.setDataNascimento(dataGerada);

            List<String> nomes = nomeFeign.solicitarUmNomeCompleto().getBody();
            String nomeGerado = nomes.get(0) + " " + nomes.get(2);
            request.setNome(nomeGerado);

            Long cpfGerado = gerador.nextLong(111_111_111_11L, 999_999_999_99L);
            request.setDocumento(cpfGerado.toString());

            request.setRegistroTipo(PessoaRegistroTipo.FISICA);
            request.setId(null);

            clienteService.cadastrarClientePainelBancario(request);

            clientesGerados.add(new ClienteResponse(request));
        }
        return clientesGerados;
    }

}
