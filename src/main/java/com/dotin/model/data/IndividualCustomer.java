package com.dotin.model.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "IndividualCustomer")
@PrimaryKeyJoinColumn(name = "customerID")
public class IndividualCustomer extends Customer {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String fatherName;

    @Getter
    @Setter
    private String birthDate;

    @Getter
    @Setter
    private String nationalCode;
}
