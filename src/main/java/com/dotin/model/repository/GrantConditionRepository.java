package com.dotin.model.repository;

import com.dotin.model.data.GrantCondition;
import com.dotin.model.data.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface GrantConditionRepository extends JpaRepository<GrantCondition, Integer> {

    List<GrantCondition> findAllByLoanType(LoanType loanType);
}
