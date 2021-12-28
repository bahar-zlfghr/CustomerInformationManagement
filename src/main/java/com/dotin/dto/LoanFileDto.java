package com.dotin.dto;

import java.math.BigDecimal;

/**
 * @author : Bahar Zolfaghari
 **/
public class LoanFileDto {
    private Integer period;
    private BigDecimal amount;
    private String loanTypeName;
    private int loanTypeInterestRate;

    public Integer getPeriod() {
        return period;
    }

    public LoanFileDto setPeriod(Integer period) {
        this.period = period;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LoanFileDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public LoanFileDto setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
        return this;
    }

    public Integer getLoanTypeInterestRate() {
        return loanTypeInterestRate;
    }

    public LoanFileDto setLoanTypeInterestRate(Integer loanTypeInterestRate) {
        this.loanTypeInterestRate = loanTypeInterestRate;
        return this;
    }
}
