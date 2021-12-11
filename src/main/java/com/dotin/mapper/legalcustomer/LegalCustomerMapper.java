package com.dotin.mapper.legalcustomer;

import com.dotin.dto.LegalCustomerDto;
import com.dotin.model.data.LegalCustomer;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LegalCustomerMapper {

    LegalCustomer toLegalCustomer(LegalCustomerDto legalCustomerDto);
    LegalCustomerDto toLegalCustomerDto(LegalCustomer legalCustomer);
}
