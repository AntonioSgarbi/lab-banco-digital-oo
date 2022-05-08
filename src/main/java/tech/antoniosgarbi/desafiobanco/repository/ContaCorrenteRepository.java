package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;

@Repository
public interface ContaCorrenteRepository
        extends JpaRepository<ContaCorrente, Long>, JpaSpecificationExecutor<ContaCorrente> {
}
