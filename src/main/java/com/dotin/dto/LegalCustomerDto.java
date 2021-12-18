package com.dotin.dto;


/**
 * @author : Bahar Zolfaghari
 **/
public class LegalCustomerDto {
    private Integer customerNO;
    private String companyName;
    private String registrationDate;
    private String economicCode;

    public Integer getCustomerNO() {
        return customerNO;
    }

    public LegalCustomerDto setCustomerNO(Integer customerNO) {
        this.customerNO = customerNO;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LegalCustomerDto setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public LegalCustomerDto setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public LegalCustomerDto setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
        return this;
    }
}
