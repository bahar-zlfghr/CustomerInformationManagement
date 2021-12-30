package com.dotin.dto;

import java.math.BigDecimal;

/**
 * @author : Bahar Zolfaghari
 **/
public class LoanFileDto {
    private Integer period;
    private BigDecimal amount;
    private CustomerDto realCustomer;
    private LoanTypeDto loanType;
    private Integer realCustomerNO;
    private Integer loanTypeID;

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

    public CustomerDto getRealCustomer() {
        return realCustomer;
    }

    public LoanFileDto setRealCustomer(CustomerDto realCustomer) {
        this.realCustomer = realCustomer;
        return this;
    }

    public LoanTypeDto getLoanType() {
        return loanType;
    }

    public LoanFileDto setLoanType(LoanTypeDto loanType) {
        this.loanType = loanType;
        return this;
    }

    public Integer getRealCustomerNO() {
        return realCustomerNO;
    }

    public LoanFileDto setRealCustomerNO(Integer realCustomerNO) {
        this.realCustomerNO = realCustomerNO;
        return this;
    }

    public Integer getLoanTypeID() {
        return loanTypeID;
    }

    public LoanFileDto setLoanTypeID(Integer loanTypeID) {
        this.loanTypeID = loanTypeID;
        return this;
    }
}
