package com.dotin.exception;

/**
 * @author : Bahar Zolfaghari
 **/
public class LoanFilePeriodNotValidException extends RuntimeException {

    public LoanFilePeriodNotValidException(String message) {
        super(message);
    }
}
