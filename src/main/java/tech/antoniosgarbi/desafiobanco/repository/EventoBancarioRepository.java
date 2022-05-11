package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.antoniosgarbi.desafiobanco.dto.evento.Movimentacao;
import tech.antoniosgarbi.desafiobanco.model.Conta;
import tech.antoniosgarbi.desafiobanco.model.EventoBancario;

public interface EventoBancarioRepository extends JpaRepository<EventoBancario, Long> {

    Page<Movimentacao> findAllByConta(Conta conta, Pageable pageable);

}
