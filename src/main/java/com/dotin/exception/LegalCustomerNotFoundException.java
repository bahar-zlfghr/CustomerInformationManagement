package com.dotin.exception;

/**
 * @author : Bahar Zolfaghari
 **/
public class LegalCustomerNotFoundException extends RuntimeException {

    public LegalCustomerNotFoundException(String message) {
        super(message);
    }
}
