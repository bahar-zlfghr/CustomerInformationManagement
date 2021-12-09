package com.dotin.service.individualcustomer;

import com.dotin.exception.DuplicateIndividualCustomerException;
import com.dotin.model.data.IndividualCustomer;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface IndividualCustomerService {

    IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer) throws DuplicateIndividualCustomerException;
    List<IndividualCustomer> findAllIndividualCustomers();
    void deleteIndividualCustomer(Integer customerNO);
    IndividualCustomer findIndividualCustomerByCustomerNO(Integer customerNO);
    IndividualCustomer updateIndividualCustomer(IndividualCustomer individualCustomer);
}
