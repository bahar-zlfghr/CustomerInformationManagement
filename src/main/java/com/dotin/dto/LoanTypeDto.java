package com.dotin.dto;

/**
 * @author : Bahar Zolfaghari
 **/
public class LoanTypeDto {
    private Integer id;
    private String name;
    private Integer interestRate;

    public Integer getId() {
        return id;
    }

    public LoanTypeDto setId(Integer id) {
        this.id = id;
        return this;
    }

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
