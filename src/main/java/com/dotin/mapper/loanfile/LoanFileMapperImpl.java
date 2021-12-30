package com.dotin.mapper.loanfile;

import com.dotin.dto.LoanFileDto;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.mapper.realcustomer.RealCustomerMapper;
import com.dotin.model.data.LoanFile;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class LoanFileMapperImpl implements LoanFileMapper {
    private final RealCustomerMapper realCustomerMapper;
    private final LoanTypeMapper loanTypeMapper;

    public LoanFileMapperImpl(RealCustomerMapper realCustomerMapper, LoanTypeMapper loanTypeMapper) {
        this.realCustomerMapper = realCustomerMapper;
        this.loanTypeMapper = loanTypeMapper;
    }

    @Override
    public LoanFile toLoanFile(LoanFileDto loanFileDto) {
        return new LoanFile()
                .setPeriod(loanFileDto.getPeriod())
                .setAmount(loanFileDto.getAmount())
                .setRealCustomer(
                        realCustomerMapper.toRealCustomer(loanFileDto.getRealCustomer()))
                .setLoanType(
                        loanTypeMapper.toLoanType(loanFileDto.getLoanType()));
    }

    @Override
    public LoanFileDto toLoanFileDto(LoanFile loanFile) {
        return new LoanFileDto()
                .setPeriod(loanFile.getPeriod())
                .setAmount(loanFile.getAmount())
                .setRealCustomer(
                        realCustomerMapper.toRealCustomerDto(loanFile.getRealCustomer()))
                .setLoanType(
                        loanTypeMapper.toLoanTypeDto(loanFile.getLoanType()));
    }
}
