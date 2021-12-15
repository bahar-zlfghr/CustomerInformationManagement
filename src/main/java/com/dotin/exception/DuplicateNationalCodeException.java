package com.dotin.exception;

/**
 * @author : Bahar Zolfaghari
 **/
public class DuplicateNationalCodeException extends RuntimeException {

    public DuplicateNationalCodeException(String message) {
        super(message);
    }
}
