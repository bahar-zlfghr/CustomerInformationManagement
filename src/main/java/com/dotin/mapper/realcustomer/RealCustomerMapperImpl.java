package com.dotin.mapper.realcustomer;

import com.dotin.dto.RealCustomerDto;
import com.dotin.model.data.RealCustomer;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class RealCustomerMapperImpl implements RealCustomerMapper {

    @Override
    public RealCustomer toRealCustomer(RealCustomerDto realCustomerDto) {
        return (RealCustomer) new RealCustomer()
                .setLastName(realCustomerDto.getLastName())
                .setFatherName(realCustomerDto.getFatherName())
                .setCustomerNO(realCustomerDto.getCustomerNO())
                .setName(realCustomerDto.getFirstName())
                .setDate(realCustomerDto.getBirthDate())
                .setCode(realCustomerDto.getNationalCode());

    }

    @Override
    public RealCustomerDto toRealCustomerDto(RealCustomer realCustomer) {
        return new RealCustomerDto()
                .setCustomerNO(realCustomer.getCustomerNO())
                .setFirstName(realCustomer.getName())
                .setLastName(realCustomer.getLastName())
                .setFatherName(realCustomer.getFatherName())
                .setBirthDate(realCustomer.getDate())
                .setNationalCode(realCustomer.getCode());
    }
}
