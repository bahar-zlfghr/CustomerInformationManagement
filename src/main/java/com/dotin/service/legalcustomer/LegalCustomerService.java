package com.dotin.service.legalcustomer;

import com.dotin.dto.LegalCustomerDto;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LegalCustomerService {

    LegalCustomerDto saveLegalCustomer(LegalCustomerDto legalCustomerDto);
    List<LegalCustomerDto> findAllLegalCustomers();
    void deleteLegalCustomerDto(Integer customerNO);
    LegalCustomerDto findLegalCustomerDtoByCustomerNO(Integer customerNO);
    void updateLegalCustomerDto(LegalCustomerDto legalCustomerDto);
}
