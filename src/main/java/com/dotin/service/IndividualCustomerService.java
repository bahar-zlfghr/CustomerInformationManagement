package com.dotin.service;

import com.dotin.exception.DuplicateIndividualCustomerException;
import com.dotin.model.data.IndividualCustomer;

/**
 * @author : Bahar Zolfaghari
 **/
public interface IndividualCustomerService {

    void saveCustomer(IndividualCustomer individualCustomer) throws DuplicateIndividualCustomerException;
}
