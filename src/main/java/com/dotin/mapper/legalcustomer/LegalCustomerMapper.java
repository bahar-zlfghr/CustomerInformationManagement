package com.dotin.mapper.legalcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.model.data.LegalCustomer;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LegalCustomerMapper {

    LegalCustomer toLegalCustomer(CustomerDto legalCustomerDto);
    CustomerDto toLegalCustomerDto(LegalCustomer legalCustomer);
}
