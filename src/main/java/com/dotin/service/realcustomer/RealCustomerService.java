package com.dotin.service.realcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.exception.DuplicateRealCustomerException;
import com.dotin.exception.DuplicateNationalCodeException;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface RealCustomerService {

    CustomerDto saveRealCustomer(CustomerDto realCustomerDto) throws DuplicateRealCustomerException;
    List<CustomerDto> findAllRealCustomers(String firstName, String lastName, String nationalCode, String customerNO);
    void deleteRealCustomer(Integer customerNO);
    CustomerDto findRealCustomerByCustomerNO(Integer customerNO);
    void updateRealCustomer(CustomerDto realCustomerDto) throws DuplicateNationalCodeException;
}
