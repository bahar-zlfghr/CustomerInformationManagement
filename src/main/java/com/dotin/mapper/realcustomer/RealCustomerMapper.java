package com.dotin.mapper.realcustomer;

import com.dotin.dto.RealCustomerDto;
import com.dotin.model.data.RealCustomer;

/**
 * @author : Bahar Zolfaghari
 **/
public interface RealCustomerMapper {

    RealCustomer toRealCustomer(RealCustomerDto realCustomerDto);
    RealCustomerDto toRealCustomerDto(RealCustomer realCustomer);
}
