package com.dotin.service.validator;

import com.dotin.dto.CustomerDto;
import com.dotin.model.data.LegalCustomer;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public interface LegalCustomerValidator {

    static boolean validateLegalCustomerForSaveOperation(Optional<LegalCustomer> existingRealCustomer) {
        return !existingRealCustomer.isPresent();
    }

    static boolean validateLegalCustomerForUpdateOperation(Optional<LegalCustomer> existingRealCustomer, CustomerDto legalCustomerDto) {
        if (existingRealCustomer.isPresent()) {
            LegalCustomer legalCustomer = existingRealCustomer.get();
            return legalCustomer.getCustomerNO().equals(legalCustomerDto.getCustomerNO());
        }
        return true;
    }
}
