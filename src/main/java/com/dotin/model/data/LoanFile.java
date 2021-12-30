package com.dotin.model.data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity
@Table(name = "LoanFiles")
public class LoanFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private Integer period;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "realCustomerNO")
    private RealCustomer realCustomer;

    @ManyToOne
    @JoinColumn(name = "loanTypeID")
    private LoanType loanType;

    public Integer getId() {
        return id;
    }

    public LoanFile setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPeriod() {
        return period;
    }

    public LoanFile setPeriod(Integer period) {
        this.period = period;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LoanFile setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public RealCustomer getRealCustomer() {
        return realCustomer;
    }

    public LoanFile setRealCustomer(RealCustomer realCustomer) {
        this.realCustomer = realCustomer;
        return this;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public LoanFile setLoanType(LoanType loanType) {
        this.loanType = loanType;
        return this;
    }
}
