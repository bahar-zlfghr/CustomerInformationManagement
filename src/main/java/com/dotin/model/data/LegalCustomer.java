package com.dotin.model.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "LegalCustomer")
@Table(name = "LegalCustomer")
@PrimaryKeyJoinColumn(name = "customerNO")
public class LegalCustomer extends Customer {

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    private String economicCode;

    @Getter
    @Setter
    private String registrationDate;
}
