package com.dotin.exception;

/**
 * @author : Bahar Zolfaghari
 **/
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
