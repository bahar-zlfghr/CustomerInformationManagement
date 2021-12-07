package com.dotin.model.repository;

import com.dotin.model.data.Customer;
import com.dotin.model.data.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {

    Optional<Customer> findByNationalCode(String nationalCode);
}
