package com.dotin.mapper.loantype;

import com.dotin.dto.LoanTypeDto;
import com.dotin.model.data.LoanType;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LoanTypeMapper {

    LoanType toLoanType(LoanTypeDto loanTypeDto);
    LoanTypeDto toLoanTypeDto(LoanType loanType);
}
