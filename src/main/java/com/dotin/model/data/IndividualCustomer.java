package com.dotin.model.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "IndividualCustomer")
@Table(name = "IndividualCustomer")
@PrimaryKeyJoinColumn(name = "customerNO")
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
