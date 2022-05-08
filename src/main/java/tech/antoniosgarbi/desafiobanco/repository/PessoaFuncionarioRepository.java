package tech.antoniosgarbi.desafiobanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tech.antoniosgarbi.desafiobanco.model.PessoaFuncionario;

@Repository
public interface PessoaFuncionarioRepository
        extends JpaRepository<PessoaFuncionario, Long>, JpaSpecificationExecutor<PessoaFuncionario> {
}
