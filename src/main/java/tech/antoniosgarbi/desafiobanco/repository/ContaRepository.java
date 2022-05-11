package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>, JpaSpecificationExecutor<Conta> {

    Optional<Conta> findContaByNumeroAndCliente(Long numero, PessoaCliente cliente);

    Optional<Conta> findByChavePix(String chavePix);
}
