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
    void deleteLegalCustomer(Integer customerNO);
    CustomerDto findLegalCustomerByCustomerNO(Integer customerNO);
    void updateLegalCustomer(CustomerDto legalCustomerDto) throws DuplicateEconomicCodeException;
}
