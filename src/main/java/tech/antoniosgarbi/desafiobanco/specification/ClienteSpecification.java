package tech.antoniosgarbi.desafiobanco.specification;

import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCliente;
import tech.antoniosgarbi.desafiobanco.model.Cliente;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class ClienteSpecification implements Specification<Cliente> {
    private final SpecBodyCliente specBodyCliente;
    private final List<Predicate> predicates;

    public ClienteSpecification(SpecBodyCliente specBodyCliente) {
        this.specBodyCliente = specBodyCliente;
        this.predicates = new LinkedList<>();
    }

    @Override
    public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (specBodyCliente.getNome() != null) {
            predicates.add(
                    builder.like(
                            builder.upper(root.get("nome")),
                            String.format("%%%s%%", specBodyCliente.getNome().toUpperCase())
                    ));
        }
        if (specBodyCliente.getDataNascimentoExata() != null) {
            predicates.add(builder.equal(root.get("dataNascimento"), specBodyCliente.getDataNascimentoExata()));
        } else {
            if (specBodyCliente.getDataNascimentoMinima() != null) {
                predicates.add(
                        builder.greaterThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCliente.getDataNascimentoMinima())
                );
            }
            if (specBodyCliente.getDataNascimentoMaxima() != null) {
                predicates.add(
                        builder.lessThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCliente.getDataNascimentoMinima())
                );
            }
        }
        if(specBodyCliente.getPessoaRegistroTipo() != null) {
            predicates.add(
              builder.equal(root.get("registroTipo"), specBodyCliente.getPessoaRegistroTipo())
            );
        }
        if(specBodyCliente.getIdsContaCorrente() != null) {
            predicates.add(
                    builder.or(
                            root.get("contasCorrente").get("id").in(specBodyCliente.getIdsContaCorrente()))
            );
        }
        if(specBodyCliente.getIdsContaPoupanca() != null) {
            predicates.add(
                    builder.or(
                            root.get("contasPoupanca").get("id").in(specBodyCliente.getIdsContaPoupanca()))
            );
        }
        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
