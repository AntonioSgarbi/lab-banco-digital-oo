package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.antoniosgarbi.desafiobanco.model.Cartao;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.Conta;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>, JpaSpecificationExecutor<Conta> {

    Optional<Conta> findContaByNumeroAndCliente(Long numero, Cliente cliente);

    Optional<Conta> findByChavePix(String chavePix);

    Optional<Conta> findByCartoesContaining(Cartao cartao);
}
