package com.dotin.exception;

/**
 * @author : Bahar Zolfaghari
 **/
public class DuplicateRealCustomerException extends RuntimeException {

    public DuplicateRealCustomerException(String message) {
        super(message);
    }
}
