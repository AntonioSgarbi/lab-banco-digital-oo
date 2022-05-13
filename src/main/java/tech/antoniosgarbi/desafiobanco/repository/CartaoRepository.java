package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.antoniosgarbi.desafiobanco.model.Cartao;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long>, JpaSpecificationExecutor<Cartao> {
    Optional<Cartao> findByNumero(String numero);
}
