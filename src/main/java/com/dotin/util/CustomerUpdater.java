package com.dotin.util;

import com.dotin.model.data.IndividualCustomer;

/**
 * @author : Bahar Zolfaghari
 **/
public interface CustomerUpdater {

    static IndividualCustomer updateIndividualCustomer(IndividualCustomer updatingIndividualCustomer,
                                                       IndividualCustomer individualCustomer) {
        updatingIndividualCustomer.setFirstName(individualCustomer.getFirstName());
        updatingIndividualCustomer.setLastName(individualCustomer.getLastName());
        updatingIndividualCustomer.setFatherName(individualCustomer.getFatherName());
        updatingIndividualCustomer.setBirthDate(individualCustomer.getBirthDate());
        updatingIndividualCustomer.setNationalCode(individualCustomer.getNationalCode());
        return updatingIndividualCustomer;
    }
}
