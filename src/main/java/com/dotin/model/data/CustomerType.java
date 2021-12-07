package com.dotin.model.data;

import lombok.Getter;

/**
 * @author : Bahar Zolfaghari
 **/
public enum CustomerType {
    INDIVIDUAL("حقیقی"), LEGAL("حقوقی");

    @Getter
    private final String customerType;

    CustomerType(String customerType) {
        this.customerType = customerType;
    }
}
