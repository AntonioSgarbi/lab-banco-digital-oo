package tech.antoniosgarbi.desafiobanco.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.*;
import tech.antoniosgarbi.desafiobanco.exception.CadastroDuplicado;
import tech.antoniosgarbi.desafiobanco.exception.CadastroInvalido;
import tech.antoniosgarbi.desafiobanco.model.Cartao;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.User;
import tech.antoniosgarbi.desafiobanco.repository.ClienteRepository;
import tech.antoniosgarbi.desafiobanco.service.impl.ClienteService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteService underTest;

    @Test
    @DisplayName("Deve retornar Page<ClienteResponse> ao receber SpecBodyCliente")
    void pesquisarClientes0(){
        List<Cliente> listaModel = List.of(Builder.clienteValido(), Builder.clienteValido());
        Page<Cliente> pageModel = new PageImpl<>(listaModel);

        SpecBodyCliente specBodyCliente = new SpecBodyCliente();

        when(clienteRepository.findAll((Specification<Cliente>) any(), (Pageable) any())).thenReturn(pageModel);

        Page<ClienteResponse> resultado = underTest.pesquisarClientes(specBodyCliente, Pageable.unpaged());

        assertNotNull(resultado.getContent());
        assertNotNull(resultado.getContent().get(0));
        assertNotNull(resultado.getContent().get(1));

        int totalElementosEsperado = 2;
        assertEquals(totalElementosEsperado, resultado.getTotalElements());
    }

    @Test
    @DisplayName("Deve retornar ClienteCadastroResponse ao Receber ClienteCadastroRequest com dados válidos")
    void cadastrarClientePainelBancario0() {
        ClienteCadastroRequest request = Builder.clienteCadastroRequest();

        when(clienteRepository.findByDocumento(anyString())).thenReturn(Optional.empty());

        ClienteCadastroResponse response = underTest.cadastrarClientePainelBancario(request);
        String mensagemEsperada = "Cadastro realizado";
        assertEquals(mensagemEsperada, response.getMensagem());
    }

    @Test
    @DisplayName("Deve lançar CadastroDuplicado ao receber request com documento que já está cadastrado")
    void cadastrarClientePainelBancario1() {
        ClienteCadastroRequest request = Builder.clienteCadastroRequest();
        Cliente cadastroExistente = Builder.clienteValido();

        when(clienteRepository.findByDocumento(anyString())).thenReturn(Optional.of(cadastroExistente));

        var exception =
                assertThrows(CadastroDuplicado.class, () -> underTest.cadastrarClientePainelBancario(request));

        String mensagemEsperada = "Essa pessoa já possui um cadastro de cliente, edite seu registro";
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar CadastroInválido ao receber request com dados de um menor de idade")
    void cadastrarClientePainelBancario2() {
        ClienteCadastroRequest request = Builder.clienteCadastroRequest();
        LocalDate dataRequest = LocalDate.now();
        request.setDataNascimento(dataRequest);

        int dezoitoAnosAtras = dataRequest.getYear() - 18;

        LocalDate dataLimite = LocalDate.of(dezoitoAnosAtras, dataRequest.getMonth(), dataRequest.getDayOfMonth());

        boolean isMenorDeidade = request.getDataNascimento().isAfter(dataLimite);

        assertTrue(isMenorDeidade);

        when(clienteRepository.findByDocumento(anyString())).thenReturn(Optional.empty());

        var exception =
                assertThrows(CadastroInvalido.class, () -> underTest.cadastrarClientePainelBancario(request));

        String mensagemEsperada = "Menores de idade não podem ser cadastrados";
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    @DisplayName("Deve retornar um cliente através do id de User")
    void encontrarPeloUsuario() {
        Cliente mock = Builder.clienteValido();
        User user = Builder.userValido();
        mock.setUser(user);

        when(clienteRepository.findClienteByUserId(anyLong()))
                .thenReturn(Optional.of(mock));

        Cliente retorno = underTest.encontrarPeloUsuario(1L);

        assertNotNull(mock);

    }

}
