package com.dotin.model.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "LegalCustomer")
@PrimaryKeyJoinColumn(name = "customerID")
public class LegalCustomer extends Customer {

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    private String economicCode;
}
