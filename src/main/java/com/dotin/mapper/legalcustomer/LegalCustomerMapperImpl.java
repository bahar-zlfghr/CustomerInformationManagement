package com.dotin.mapper.legalcustomer;

import com.dotin.dto.LegalCustomerDto;
import com.dotin.model.data.LegalCustomer;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class LegalCustomerMapperImpl implements LegalCustomerMapper {

    @Override
    public LegalCustomer toLegalCustomer(LegalCustomerDto legalCustomerDto) {
        return (LegalCustomer) new LegalCustomer()
                .setCustomerNO(legalCustomerDto.getCustomerNO())
                .setName(legalCustomerDto.getCompanyName())
                .setDate(legalCustomerDto.getRegistrationDate())
                .setCode(legalCustomerDto.getEconomicCode());
    }

    @Override
    public LegalCustomerDto toLegalCustomerDto(LegalCustomer legalCustomer) {
        return new LegalCustomerDto()
                .setCustomerNO(legalCustomer.getCustomerNO())
                .setCompanyName(legalCustomer.getName())
                .setRegistrationDate(legalCustomer.getDate())
                .setEconomicCode(legalCustomer.getCode());
    }
}
