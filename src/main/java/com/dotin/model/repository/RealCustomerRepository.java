package com.dotin.model.repository;

import com.dotin.model.data.RealCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface RealCustomerRepository extends JpaRepository<RealCustomer, Integer>, JpaSpecificationExecutor<RealCustomer> {

    Optional<RealCustomer> findByCode(String nationalCode);
    Optional<RealCustomer> findByCustomerNO(Integer customerNO);
}
