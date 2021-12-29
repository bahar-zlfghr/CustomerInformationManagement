package com.dotin.model.repository;

import com.dotin.model.data.LegalCustomer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LegalCustomerSpecification {

    static Specification<LegalCustomer> search(String companyName, String economicCode, String customerNO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            CriteriaQuery<LegalCustomer> customerCriteriaQuery = criteriaBuilder.createQuery(LegalCustomer.class);
            if (!Objects.isNull(companyName) && !companyName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("name"), companyName));
            }
            if (!Objects.isNull(economicCode) && !economicCode.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("code"), economicCode));
            }
            if (!Objects.isNull(customerNO) && !customerNO.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("customerNO"), customerNO));
            }
            return customerCriteriaQuery.select(root).where(predicates.toArray(new Predicate[0])).getRestriction();
        };
    }
}
