package com.dotin.service.legalcustomer;

import com.dotin.model.data.LegalCustomer;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface LegalCustomerService {

    LegalCustomer saveLegalCustomer(LegalCustomer legalCustomer);
    List<LegalCustomer> findAllLegalCustomers();
    void deleteLegalCustomer(Integer customerNO);
}
