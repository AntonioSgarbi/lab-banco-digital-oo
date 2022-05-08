package tech.antoniosgarbi.desafiobanco.specification;

import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyContaCorrente;
import tech.antoniosgarbi.desafiobanco.model.ContaCorrente;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class ContaCorrenteSpecification implements Specification<ContaCorrente> {
    private final SpecBodyContaCorrente contaSpecBody;
    private final List<Predicate> predicates;

    public ContaCorrenteSpecification(SpecBodyContaCorrente contaSpecBody) {
        this.contaSpecBody = contaSpecBody;
        this.predicates = new LinkedList<>();
    }

    @Override
    public Predicate toPredicate(Root<ContaCorrente> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (contaSpecBody.getNumero() != null) {
            predicates.add(cb.equal(root.get("numero"), contaSpecBody.getNumero()));
        } else {
            if (contaSpecBody.getSaldoExato() != null) {
                predicates.add(cb.equal(root.get("saldo"), contaSpecBody.getSaldoExato()));
            } else {
                if (contaSpecBody.getSaldoMinimo() != null) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("saldo"), contaSpecBody.getSaldoMaximo()));
                }
                if (contaSpecBody.getSaldoMaximo() != null) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("saldo"), contaSpecBody.getSaldoMaximo()));
                }
            }
            if(contaSpecBody.getLimiteExato() != null) {
                predicates.add(cb.equal(root.get("saldo"), contaSpecBody.getSaldoExato()));
            } else {
                if (contaSpecBody.getLimiteMinimo() != null) {
                    predicates.add(cb.greaterThan(root.get("limiteAprovado"), contaSpecBody.getLimiteMinimo()));
                }
                if(contaSpecBody.getLimiteMaximo() != null) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("limiteAprovado"), contaSpecBody.getLimiteMaximo()));
                }
            }
            if(contaSpecBody.getAgencia() != null) {
                predicates.add(cb.equal(root.get("agencia"), contaSpecBody.getAgencia()));
            }
            if(contaSpecBody.getCliente() != null) {
                predicates.add(cb.equal(root.get("cliente"), contaSpecBody.getCliente()));
            }
        }
        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
