package com.dotin.service.legalcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.exception.DuplicateEconomicCodeException;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LegalCustomerService {

    CustomerDto saveLegalCustomer(CustomerDto legalCustomerDto);
    List<CustomerDto> findAllLegalCustomers(String companyName, String economicCode, String customerNO);
    void deleteLegalCustomerDto(Integer customerNO);
    CustomerDto findLegalCustomerDtoByCustomerNO(Integer customerNO);
    void updateLegalCustomerDto(CustomerDto legalCustomerDto) throws DuplicateEconomicCodeException;
}
