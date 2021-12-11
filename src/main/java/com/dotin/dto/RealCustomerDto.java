package com.dotin.dto;

/**
 * @author : Bahar Zolfaghari
 **/
public class RealCustomerDto {
    private Integer customerNO;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthDate;
    private String nationalCode;

    public Integer getCustomerNO() {
        return customerNO;
    }

    public RealCustomerDto setCustomerNO(Integer customerNO) {
        this.customerNO = customerNO;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RealCustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RealCustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public RealCustomerDto setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public RealCustomerDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public RealCustomerDto setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }
}
