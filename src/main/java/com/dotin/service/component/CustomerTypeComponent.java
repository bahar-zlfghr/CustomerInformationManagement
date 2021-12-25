package com.dotin.service.component;

import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class CustomerTypeComponent {

    public String getCustomerType(String key) {
        if (key.equals(PropertyReaderComponent.getProperty("customer.type.real.binary"))) {
            return PropertyReaderComponent.getProperty("customer.type.real.text");
        }
        else if (key.equals(PropertyReaderComponent.getProperty("customer.type.legal.binary"))) {
            return PropertyReaderComponent.getProperty("customer.type.legal.text");
        }
        else {
            return null;
        }
    }
}
