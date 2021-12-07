package com.dotin.exception;

import com.dotin.model.data.IndividualCustomer;
import lombok.Getter;

/**
 * @author : Bahar Zolfaghari
 **/
public class DuplicateIndividualCustomerException extends RuntimeException {

    @Getter
    private final IndividualCustomer individualCustomer;

    public DuplicateIndividualCustomerException(String message, IndividualCustomer individualCustomer) {
        super(message);
        this.individualCustomer = individualCustomer;
    }
}
