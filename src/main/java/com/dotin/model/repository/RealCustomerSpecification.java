package com.dotin.model.repository;

import com.dotin.model.data.RealCustomer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Bahar Zolfaghari
 **/
public interface RealCustomerSpecification {

    static Specification<RealCustomer> search(String firstName, String lastName, String nationalCode, String customerNO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            CriteriaQuery<RealCustomer> customerCriteriaQuery = criteriaBuilder.createQuery(RealCustomer.class);
            if (!Objects.isNull(firstName) && !firstName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("name"), firstName));
            }
            if (!Objects.isNull(lastName) && !lastName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("lastName"), lastName));
            }
            if (!Objects.isNull(nationalCode) && !nationalCode.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("code"), nationalCode));
            }
            if (!Objects.isNull(customerNO) && !customerNO.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("customerNO"), customerNO));
            }
            return customerCriteriaQuery.select(root).where(predicates.toArray(new Predicate[0])).getRestriction();
        };
    }
}
