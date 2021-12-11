package com.dotin.model.data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity(name = "Customer")
@Table(name = "Customers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customerType")
@DiscriminatorValue(value = "-")
public class Customer {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "CustomerNumberSequence"),
                    @Parameter(name = "initial_value", value = "10000001"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer customerNO;

    private String name;

    @Column(name = "`datee`")
    private String date;

    private String code;

    public Integer getCustomerNO() {
        return customerNO;
    }

    public Customer setCustomerNO(Integer customerNO) {
        this.customerNO = customerNO;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Customer setDate(String date) {
        this.date = date;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Customer setCode(String code) {
        this.code = code;
        return this;
    }
}
