package com.dotin.mapper.legalcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.service.component.CustomerTypeComponent;
import com.dotin.model.data.LegalCustomer;
import com.dotin.service.component.PropertyReaderComponent;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class LegalCustomerMapperImpl implements LegalCustomerMapper {
    private final CustomerTypeComponent customerTypeComponent;

    public LegalCustomerMapperImpl(CustomerTypeComponent customerTypeComponent) {
        this.customerTypeComponent = customerTypeComponent;
    }

    @Override
    public LegalCustomer toLegalCustomer(CustomerDto legalCustomerDto) {
        return (LegalCustomer) new LegalCustomer()
                .setCustomerNO(legalCustomerDto.getCustomerNO())
                .setName(legalCustomerDto.getName())
                .setDate(legalCustomerDto.getDate())
                .setCode(legalCustomerDto.getCode());
    }

    @Override
    public CustomerDto toLegalCustomerDto(LegalCustomer legalCustomer) {
        return new CustomerDto()
                .setCustomerNO(legalCustomer.getCustomerNO())
                .setCustomerType(customerTypeComponent.getCustomerType(
                        PropertyReaderComponent.getProperty("customer.type.legal.binary")))
                .setName(legalCustomer.getName())
                .setDate(legalCustomer.getDate())
                .setCode(legalCustomer.getCode());
    }
}
