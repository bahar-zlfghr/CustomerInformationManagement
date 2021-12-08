package com.dotin.service;

import com.dotin.exception.DuplicateIndividualCustomerException;
import com.dotin.model.data.IndividualCustomer;

/**
 * @author : Bahar Zolfaghari
 **/
public interface IndividualCustomerService {

    IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer) throws DuplicateIndividualCustomerException;
}
