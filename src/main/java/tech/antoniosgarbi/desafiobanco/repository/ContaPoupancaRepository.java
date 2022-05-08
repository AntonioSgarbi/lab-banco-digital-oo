package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.antoniosgarbi.desafiobanco.model.ContaPoupanca;

@Repository
public interface ContaPoupancaRepository
        extends JpaRepository<ContaPoupanca, Long>, JpaSpecificationExecutor<ContaPoupanca> {
}
