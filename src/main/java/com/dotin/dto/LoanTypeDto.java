package com.dotin.dto;

/**
 * @author : Bahar Zolfaghari
 **/
public class LoanTypeDto {
    private String name;
    private Integer interestRate;

    public String getName() {
        return name;
    }

    public LoanTypeDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public LoanTypeDto setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
        return this;
    }
}
