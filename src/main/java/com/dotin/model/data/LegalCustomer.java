package com.dotin.model.data;

import com.dotin.configuration.property.CustomerProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "LegalCustomer")
@DiscriminatorValue(value = CustomerProperties.LEGAL_BINARY)
public class LegalCustomer extends Customer {

}
