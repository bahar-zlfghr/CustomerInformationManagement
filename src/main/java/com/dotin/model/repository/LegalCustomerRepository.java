package com.dotin.model.repository;

import com.dotin.model.data.LegalCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface LegalCustomerRepository extends JpaRepository<LegalCustomer, Integer> {

    Optional<LegalCustomer> findByEconomicCode(String economicCode);
    Optional<LegalCustomer> findByCustomerNO(Integer customerNo);
}
