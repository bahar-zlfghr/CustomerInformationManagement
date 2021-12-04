package com.dotin.model.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "Customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer customerID;

    @Getter
    @Setter
    private String customerNO;

    @Getter
    @Setter
    private CustomerType customerType;
}
