package com.dotin.service.legalcustomer;

import com.dotin.dto.LegalCustomerDto;
import com.dotin.exception.DuplicateEconomicCodeException;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LegalCustomerService {

    LegalCustomerDto saveLegalCustomer(LegalCustomerDto legalCustomerDto);
    List<LegalCustomerDto> findAllLegalCustomers(String companyName, String economicCode, String customerNO);
    void deleteLegalCustomerDto(Integer customerNO);
    LegalCustomerDto findLegalCustomerDtoByCustomerNO(Integer customerNO);
    void updateLegalCustomerDto(LegalCustomerDto legalCustomerDto) throws DuplicateEconomicCodeException;
}
