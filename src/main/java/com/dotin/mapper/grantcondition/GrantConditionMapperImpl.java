package com.dotin.mapper.grantcondition;

import com.dotin.dto.GrantConditionDto;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.model.data.GrantCondition;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class GrantConditionMapperImpl implements GrantConditionMapper {
    private final LoanTypeMapper loanTypeMapper;

    public GrantConditionMapperImpl(LoanTypeMapper loanTypeMapper) {
        this.loanTypeMapper = loanTypeMapper;
    }

    @Override
    public GrantCondition toGrantCondition(GrantConditionDto grantConditionDto) {
        return new GrantCondition()
                .setName(grantConditionDto.getName())
                .setMinPeriod(grantConditionDto.getMinPeriod())
                .setMaxPeriod(grantConditionDto.getMaxPeriod())
                .setMinAmount(grantConditionDto.getMinAmount())
                .setMaxAmount(grantConditionDto.getMaxAmount())
                .setLoanType(loanTypeMapper.toLoanType(grantConditionDto.getLoanTypeDto()));
    }

    @Override
    public GrantConditionDto toGrantConditionDto(GrantCondition grantCondition) {
        return new GrantConditionDto()
                .setName(grantCondition.getName())
                .setMinPeriod(grantCondition.getMinPeriod())
                .setMaxPeriod(grantCondition.getMaxPeriod())
                .setMinAmount(grantCondition.getMinAmount())
                .setMaxAmount(grantCondition.getMaxAmount())
                .setLoanTypeDto(loanTypeMapper.toLoanTypeDto(grantCondition.getLoanType()));
    }
}
