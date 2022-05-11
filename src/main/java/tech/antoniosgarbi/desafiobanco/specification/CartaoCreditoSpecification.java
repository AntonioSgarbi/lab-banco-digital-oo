package tech.antoniosgarbi.desafiobanco.specification;

import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartaoCredito;
import tech.antoniosgarbi.desafiobanco.model.CartaoCredito;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class CartaoCreditoSpecification implements Specification<CartaoCredito> {
    private final SpecBodyCartaoCredito specBodyCartaoCredito;
    public CartaoCreditoSpecification(SpecBodyCartaoCredito specBodyCartaoCredito) {
        this.specBodyCartaoCredito = specBodyCartaoCredito;
    }

    @Override
    public Predicate toPredicate(Root<CartaoCredito> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new LinkedList<>();

        if (specBodyCartaoCredito.getNumero() != null) {
            predicates.add(
                    builder.like(
                            root.get("nome"),
                            String.format("%%%s%%", specBodyCartaoCredito.getNumero()))
            );
        }
        if (specBodyCartaoCredito.getValidadeExata() != null) {
            predicates.add(
                    builder.equal(
                            root.get("dataNascimento"),
                            specBodyCartaoCredito.getValidadeExata())
            );
        } else {
            if (specBodyCartaoCredito.getValidadeMinima() != null) {
                predicates.add(
                        builder.greaterThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartaoCredito.getValidadeMinima())
                );
            }
            if (specBodyCartaoCredito.getValidadeMaxima() != null) {
                predicates.add(
                        builder.lessThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartaoCredito.getValidadeMaxima())
                );
            }
        }
        if (specBodyCartaoCredito.getLimiteAprovadoExato() != null) {
            predicates.add(
                    builder.equal(
                            root.get("dataNascimento"),
                            specBodyCartaoCredito.getLimiteAprovadoExato())
            );
        } else {
            if (specBodyCartaoCredito.getLimiteAprovadoMinimo() != null) {
                predicates.add(
                        builder.greaterThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartaoCredito.getLimiteAprovadoMinimo())
                );
            }
            if (specBodyCartaoCredito.getLimiteAprovadoMaximo() != null) {
                predicates.add(
                        builder.lessThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartaoCredito.getLimiteAprovadoMaximo())
                );
            }
        }
        if (specBodyCartaoCredito.getStatus() != null) {
            predicates.add(
                    builder.or(
                            root.get("status").in(specBodyCartaoCredito.getStatus()))
            );
        }
        if(specBodyCartaoCredito.getContasCorrente() != null) {
            predicates.add(
                    builder.or(
                            root.get("contaCorrente").in(specBodyCartaoCredito.getContasCorrente()))
            );
        }
        if(specBodyCartaoCredito.getContasPoupanca() != null) {
            predicates.add(
                    builder.or(
                            root.get("contaPoupanca").in(specBodyCartaoCredito.getContasPoupanca()))
            );
        }
        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
