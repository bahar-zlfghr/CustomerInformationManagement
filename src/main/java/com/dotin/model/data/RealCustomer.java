package com.dotin.model.data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "RealCustomer")
@DiscriminatorValue(value = "customer.type.real.binary")
public class RealCustomer extends Customer {

    private String lastName;
    private String fatherName;

    public String getLastName() {
        return lastName;
    }

    public RealCustomer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public RealCustomer setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }
}
