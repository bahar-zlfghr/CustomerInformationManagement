package com.dotin.dto;

import java.math.BigDecimal;

/**
 * @author : Bahar Zolfaghari
 **/
public class GrantConditionDto {
    private String name;
    private Integer minPeriod;
    private Integer maxPeriod;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private LoanTypeDto loanTypeDto;

    public String getName() {
        return name;
    }

    public GrantConditionDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getMinPeriod() {
        return minPeriod;
    }

    public GrantConditionDto setMinPeriod(Integer minPeriod) {
        this.minPeriod = minPeriod;
        return this;
    }

    public Integer getMaxPeriod() {
        return maxPeriod;
    }

    public GrantConditionDto setMaxPeriod(Integer maxPeriod) {
        this.maxPeriod = maxPeriod;
        return this;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public GrantConditionDto setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public GrantConditionDto setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

    public LoanTypeDto getLoanTypeDto() {
        return loanTypeDto;
    }

    public GrantConditionDto setLoanTypeDto(LoanTypeDto loanTypeDto) {
        this.loanTypeDto = loanTypeDto;
        return this;
    }
}
