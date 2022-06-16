package tech.antoniosgarbi.desafiobanco.specification;

import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyCartao;
import tech.antoniosgarbi.desafiobanco.model.Cartao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class CartaoSpecification implements Specification<Cartao> {
    private final SpecBodyCartao specBodyCartao;
    public CartaoSpecification(SpecBodyCartao specBodyCartao) {
        this.specBodyCartao = specBodyCartao;
    }

    @Override
    public Predicate toPredicate(Root<Cartao> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new LinkedList<>();

        if (specBodyCartao.getNumero() != null) {
            predicates.add(
                    builder.like(
                            root.get("numero"),
                            String.format("%%%s%%", specBodyCartao.getNumero()))
            );
        }
        if (specBodyCartao.getValidadeExata() != null) {
            predicates.add(
                    builder.equal(
                            root.get("dataNascimento"),
                            specBodyCartao.getValidadeExata())
            );
        } else {
            if (specBodyCartao.getValidadeMinima() != null) {
                predicates.add(
                        builder.greaterThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartao.getValidadeMinima())
                );
            }
            if (specBodyCartao.getValidadeMaxima() != null) {
                predicates.add(
                        builder.lessThanOrEqualTo(
                                root.get("dataNascimento"),
                                specBodyCartao.getValidadeMaxima())
                );
            }
        }
        if (specBodyCartao.getLimiteAprovadoExato() != null) {
            predicates.add(
                    builder.equal(
                            root.get("limiteAprovado"),
                            specBodyCartao.getLimiteAprovadoExato())
            );
        } else {
            if (specBodyCartao.getLimiteAprovadoMinimo() != null) {
                predicates.add(
                        builder.greaterThanOrEqualTo(
                                root.get("limiteAprovado"),
                                specBodyCartao.getLimiteAprovadoMinimo())
                );
            }
            if (specBodyCartao.getLimiteAprovadoMaximo() != null) {
                predicates.add(
                        builder.lessThanOrEqualTo(
                                root.get("limiteAprovado"),
                                specBodyCartao.getLimiteAprovadoMaximo())
                );
            }
        }
        if (specBodyCartao.getStatusCredito() != null) {
            predicates.add(
                    builder.or(
                            root.get("status").in(specBodyCartao.getStatusCredito()))
            );
        }
        if (specBodyCartao.getStatusDebito() != null) {
            predicates.add(
                    builder.or(
                            root.get("status").in(specBodyCartao.getStatusCredito()))
            );
        }
        if(specBodyCartao.getContasCorrente() != null) {
            predicates.add(
                    builder.or(
                            root.get("contaCorrente").in(specBodyCartao.getContasCorrente()))
            );
        }
        if(specBodyCartao.getContasPoupanca() != null) {
            predicates.add(
                    builder.or(
                            root.get("contaPoupanca").in(specBodyCartao.getContasPoupanca()))
            );
        }
        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
