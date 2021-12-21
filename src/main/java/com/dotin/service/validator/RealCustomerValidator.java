package com.dotin.service.validator;

import com.dotin.dto.CustomerDto;
import com.dotin.model.data.RealCustomer;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public interface RealCustomerValidator {

    static boolean validateRealCustomerForSaveOperation(Optional<RealCustomer> existingRealCustomer) {
        return !existingRealCustomer.isPresent();
    }

    static boolean validateRealCustomerForUpdateOperation(Optional<RealCustomer> existingRealCustomer, CustomerDto realCustomerDto) {
        if (existingRealCustomer.isPresent()) {
            RealCustomer realCustomer = existingRealCustomer.get();
            return realCustomer.getCustomerNO().equals(realCustomerDto.getCustomerNO());
        }
        return true;
    }
}
