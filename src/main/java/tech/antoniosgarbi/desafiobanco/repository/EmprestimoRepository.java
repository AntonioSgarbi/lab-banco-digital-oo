package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.Emprestimo;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findAllByConta(ContaCorrente conta);


}
