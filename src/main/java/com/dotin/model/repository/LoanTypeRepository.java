package com.dotin.model.repository;

import com.dotin.model.data.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Integer> {

    Optional<LoanType> findById(Integer ID);
}
