package com.dotin.service.loantype;

import com.dotin.dto.LoanTypeDto;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LoanTypeService {

    LoanTypeDto saveLoanType(LoanTypeDto loanTypeDto);
    LoanTypeDto getLoanTypeByID(Integer customerNO);
    List<LoanTypeDto> getAllLoanTypes();
}
