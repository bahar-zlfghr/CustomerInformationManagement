package com.dotin.service.realcustomer;

import com.dotin.dto.RealCustomerDto;
import com.dotin.exception.DuplicateRealCustomerException;
import com.dotin.exception.DuplicateNationalCodeException;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface RealCustomerService {

    RealCustomerDto saveRealCustomer(RealCustomerDto realCustomerDto) throws DuplicateRealCustomerException;
    List<RealCustomerDto> findAllRealCustomers(String firstName, String lastName, String nationalCode, String customerNO);
    void deleteRealCustomer(Integer customerNO);
    RealCustomerDto findRealCustomerByCustomerNO(Integer customerNO);
    void updateRealCustomer(RealCustomerDto realCustomerDto) throws DuplicateNationalCodeException;
}
