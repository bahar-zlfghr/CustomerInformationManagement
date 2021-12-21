package com.dotin.service.component;

import org.springframework.stereotype.Component;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class CustomerTypeComponent {
    private final String REAL;
    private final String LEGAL;

    public CustomerTypeComponent(PropertyReaderComponent propertyReaderComponent) {
        this.REAL = propertyReaderComponent.getProperty("customer.type.real");
        this.LEGAL = propertyReaderComponent.getProperty("customer.type.legal");
    }

    public String getCustomerType(String key) {
        switch (key) {
            case "0":
                return REAL;
            case "1":
                return LEGAL;
            default:
                return null;
        }
    }
}
