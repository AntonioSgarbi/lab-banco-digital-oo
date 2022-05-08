package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.antoniosgarbi.desafiobanco.model.CartaoCredito;

@Repository
public interface CartaoCreditoRepository
        extends JpaRepository<CartaoCredito, Long>, JpaSpecificationExecutor<CartaoCredito> {
}
