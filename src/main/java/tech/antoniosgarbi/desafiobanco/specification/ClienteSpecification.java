package tech.antoniosgarbi.desafiobanco.specification;

import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.model.PessoaCliente;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class ClienteSpecification implements Specification<PessoaCliente> {
    private final SpecBodyCliente specBodyCliente;
    private final List<Predicate> predicates;

    public ClienteSpecification(SpecBodyCliente specBodyCliente) {
        this.specBodyCliente = specBodyCliente;
        this.predicates = new LinkedList<>();
    }

    @Override
    public Predicate toPredicate(Root<PessoaCliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (specBodyCliente.getNome() != null) {
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("nome")),
                            String.format("%%%s%%", specBodyCliente.getNome().toUpperCase())
                    ));
        }
        if (specBodyCliente.getDataNascimentoExata() != null) {
            predicates.add(criteriaBuilder.equal(root.get("dataNascimento"), specBodyCliente.getDataNascimentoExata()));
        } else {
            if (specBodyCliente.getDataNascimentoMinima() != null) {
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCliente.getDataNascimentoMinima())
                );
            }
            if (specBodyCliente.getDataNascimentoMaxima() != null) {
                predicates.add(
                        criteriaBuilder.lessThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCliente.getDataNascimentoMinima())
                );
            }
        }
        //todo
        // filtro contas???

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
