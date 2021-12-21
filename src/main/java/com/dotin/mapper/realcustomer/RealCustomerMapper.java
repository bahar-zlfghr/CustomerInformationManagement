package com.dotin.mapper.realcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.model.data.RealCustomer;

/**
 * @author : Bahar Zolfaghari
 **/
public interface RealCustomerMapper {

    RealCustomer toRealCustomer(CustomerDto realCustomerDto);
    CustomerDto toRealCustomerDto(RealCustomer realCustomer);
}
