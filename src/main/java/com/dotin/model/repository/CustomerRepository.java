package com.dotin.model.repository;

import com.dotin.model.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
