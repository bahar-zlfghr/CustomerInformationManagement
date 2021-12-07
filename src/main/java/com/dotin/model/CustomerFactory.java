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
                IndividualCustomer individualCustomer = new IndividualCustomer();
                individualCustomer.setCustomerType(customerType.getCustomerType());
                return individualCustomer;
            case LEGAL:
                LegalCustomer legalCustomer = new LegalCustomer();
                legalCustomer.setCustomerType(customerType.getCustomerType());
                return legalCustomer;
            default:
                return null;
        }
    }
}
