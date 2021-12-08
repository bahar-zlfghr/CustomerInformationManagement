package com.dotin.model;

import com.dotin.model.data.Customer;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.IndividualCustomer;
import com.dotin.model.data.LegalCustomer;
import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public interface CustomerFactory {

    static Customer createCustomer(CustomerType customerType) {
        switch (customerType) {
            case INDIVIDUAL:
                return new IndividualCustomer();
            case LEGAL:
                return new LegalCustomer();
            default:
                return null;
        }
    }
}
