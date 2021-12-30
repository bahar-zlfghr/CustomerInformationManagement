package com.dotin.mapper.loanfile;

import com.dotin.dto.LoanFileDto;
import com.dotin.model.data.LoanFile;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LoanFileMapper {

    LoanFile toLoanFile(LoanFileDto loanFileDto);
    LoanFileDto toLoanFileDto(LoanFile loanFile);
}
