package com.dotin.model.data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "LegalCustomer")
@DiscriminatorValue(value = "1")
public class LegalCustomer extends Customer {

}
