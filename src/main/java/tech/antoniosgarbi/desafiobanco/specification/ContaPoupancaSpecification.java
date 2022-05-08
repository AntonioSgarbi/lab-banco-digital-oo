package tech.antoniosgarbi.desafiobanco.specification;

import org.springframework.data.jpa.domain.Specification;
import tech.antoniosgarbi.desafiobanco.dto.painelbancario.SpecBodyContaPoupanca;
import tech.antoniosgarbi.desafiobanco.model.ContaPoupanca;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class ContaPoupancaSpecification implements Specification<ContaPoupanca> {
    private final SpecBodyContaPoupanca contaSpecBody;
    private final List<Predicate> predicates;

    public ContaPoupancaSpecification(SpecBodyContaPoupanca contaSpecBody) {
        this.contaSpecBody = contaSpecBody;
        this.predicates = new LinkedList<>();
    }

    @Override
    public Predicate toPredicate(Root<ContaPoupanca> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (contaSpecBody.getNumero() != null) {
            predicates.add(cb.equal(root.get("numero"), contaSpecBody.getNumero()));
        } else {
            if (contaSpecBody.getSaldoExato() != null) {
                predicates.add(cb.equal(root.get("saldo"), contaSpecBody.getSaldoExato()));
            } else {
                if (contaSpecBody.getSaldoMinimo() != null) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("saldo"), contaSpecBody.getSaldoMinimo()));
                }
                if (contaSpecBody.getSaldoMaximo() != null) {
                    predicates.add(cb.lessThanOrEqualTo(root.get("saldo"), contaSpecBody.getSaldoMaximo()));
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
