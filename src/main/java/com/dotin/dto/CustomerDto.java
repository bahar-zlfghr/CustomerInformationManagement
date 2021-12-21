package com.dotin.dto;

/**
 * @author : Bahar Zolfaghari
 **/
public class CustomerDto {
    private Integer customerNO;
    private String customerType;
    private String name;
    private String lastName;
    private String fatherName;
    private String date;
    private String code;

    public Integer getCustomerNO() {
        return customerNO;
    }

    public CustomerDto setCustomerNO(Integer customerNO) {
        this.customerNO = customerNO;
        return this;
    }

    public String getCustomerType() {
        return customerType;
    }

    public CustomerDto setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public CustomerDto setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getDate() {
        return date;
    }

    public CustomerDto setDate(String date) {
        this.date = date;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CustomerDto setCode(String code) {
        this.code = code;
        return this;
    }
}
