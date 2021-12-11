package com.dotin.exception;

/**
 * @author : Bahar Zolfaghari
 **/
public class RealCustomerNotFoundException extends RuntimeException {

    public RealCustomerNotFoundException(String message) {
        super(message);
    }
}
