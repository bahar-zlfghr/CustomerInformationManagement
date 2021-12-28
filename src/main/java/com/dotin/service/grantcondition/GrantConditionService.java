package com.dotin.service.grantcondition;

import com.dotin.model.data.GrantCondition;
import com.dotin.model.data.LoanType;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface GrantConditionService {

    void saveAllGrantConditions(List<GrantCondition> grantConditions);
    List<GrantCondition> findAllGrantConditionsByLoanType(LoanType loanType);
}
