package tech.antoniosgarbi.desafiobanco.specification;

import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartaoDebito;
import tech.antoniosgarbi.desafiobanco.model.CartaoDebito;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class CartaoDebitoSpecification implements Specification<CartaoDebito> {
    private final SpecBodyCartaoDebito specBodyCartaoDebito;

    public CartaoDebitoSpecification(SpecBodyCartaoDebito specBodyCartaoDebito) {
        this.specBodyCartaoDebito = specBodyCartaoDebito;
    }

    @Override
    public Predicate toPredicate(Root<CartaoDebito> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new LinkedList<>();

        if (specBodyCartaoDebito.getNumero() != null) {
            predicates.add(
                    builder.like(
                            root.get("nome"),
                            String.format("%%%s%%", specBodyCartaoDebito.getNumero()))
            );
        }
        if (specBodyCartaoDebito.getValidadeExata() != null) {
            predicates.add(
                    builder.equal(
                            root.get("dataNascimento"),
                            specBodyCartaoDebito.getValidadeExata())
            );
        } else {
            if (specBodyCartaoDebito.getValidadeMinima() != null) {
                predicates.add(
                        builder.greaterThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartaoDebito.getValidadeMinima())
                );
            }
            if (specBodyCartaoDebito.getValidadeMaxima() != null) {
                predicates.add(
                        builder.lessThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartaoDebito.getValidadeMaxima())
                );
            }
        }
        if (specBodyCartaoDebito.getStatus() != null) {
            predicates.add(
                    builder.or(
                            root.get("status").in(specBodyCartaoDebito.getStatus()))
            );
        }
        if (specBodyCartaoDebito.getContasCorrente() != null) {
            predicates.add(
                    builder.or(
                            root.get("contaCorrente").in(specBodyCartaoDebito.getContasCorrente()))
            );
        }
        if (specBodyCartaoDebito.getContasPoupanca() != null) {
            predicates.add(
                    builder.or(
                            root.get("contaPoupanca").in(specBodyCartaoDebito.getContasPoupanca()))
            );
        }
        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
