package com.dotin.exception;

/**
 * @author : Bahar Zolfaghari
 **/
public class DuplicateLegalCustomerException extends RuntimeException {

    public DuplicateLegalCustomerException(String message) {
        super(message);
    }
}
