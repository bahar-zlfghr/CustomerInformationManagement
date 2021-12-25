package com.dotin.mapper.realcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.service.component.CustomerTypeComponent;
import com.dotin.model.data.RealCustomer;
import com.dotin.service.component.PropertyReaderComponent;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class RealCustomerMapperImpl implements RealCustomerMapper {
    private final CustomerTypeComponent customerTypeComponent;

    public RealCustomerMapperImpl(CustomerTypeComponent customerTypeComponent) {
        this.customerTypeComponent = customerTypeComponent;
    }

    @Override
    public RealCustomer toRealCustomer(CustomerDto realCustomerDto) {
        return (RealCustomer) new RealCustomer()
                .setLastName(realCustomerDto.getLastName())
                .setFatherName(realCustomerDto.getFatherName())
                .setCustomerNO(realCustomerDto.getCustomerNO())
                .setName(realCustomerDto.getName())
                .setDate(realCustomerDto.getDate())
                .setCode(realCustomerDto.getCode());

    }

    @Override
    public CustomerDto toRealCustomerDto(RealCustomer realCustomer) {
        return new CustomerDto()
                .setCustomerNO(realCustomer.getCustomerNO())
                .setCustomerType(customerTypeComponent.getCustomerType(
                        PropertyReaderComponent.getProperty("customer.type.real.binary")
                ))
                .setName(realCustomer.getName())
                .setLastName(realCustomer.getLastName())
                .setFatherName(realCustomer.getFatherName())
                .setDate(realCustomer.getDate())
                .setCode(realCustomer.getCode());
    }
}
