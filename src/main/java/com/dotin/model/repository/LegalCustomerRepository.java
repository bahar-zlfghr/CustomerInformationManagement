package com.dotin.model.repository;

import com.dotin.model.data.LegalCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface LegalCustomerRepository extends JpaRepository<LegalCustomer, Integer>, JpaSpecificationExecutor<LegalCustomer> {

    Optional<LegalCustomer> findByCode(String economicCode);
    Optional<LegalCustomer> findByCustomerNO(Integer customerNo);
}
