package com.dotin.service.grantcondition;

import com.dotin.dto.GrantConditionDto;
import com.dotin.dto.LoanTypeDto;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface GrantConditionService {

    void saveAllGrantConditions(List<GrantConditionDto> grantConditions);
    List<GrantConditionDto> findAllGrantConditionsByLoanType(LoanTypeDto loanTypeDto);
}
