package com.dotin.service.loanfile;

import com.dotin.dto.CustomerDto;
import com.dotin.dto.LoanFileDto;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LoanFileService {

    void saveLoanFile(LoanFileDto loanFileDto);
    List<LoanFileDto> findLoanFilesByRealCustomer(CustomerDto realCustomer);
    List<RuntimeException> getExceptions();
}
