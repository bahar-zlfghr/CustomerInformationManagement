package com.dotin.mapper.loantype;

import com.dotin.dto.LoanTypeDto;
import com.dotin.model.data.LoanType;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class LoanTypeMapperImpl implements LoanTypeMapper {

    @Override
    public LoanType toLoanType(LoanTypeDto loanTypeDto) {
        return new LoanType()
                .setName(loanTypeDto.getName())
                .setInterestRate(loanTypeDto.getInterestRate());
    }

    @Override
    public LoanTypeDto toLoanTypeDto(LoanType loanType) {
        return new LoanTypeDto()
                .setName(loanType.getName())
                .setInterestRate(loanType.getInterestRate());
    }
}
