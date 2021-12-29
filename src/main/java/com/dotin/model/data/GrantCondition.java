package com.dotin.model.data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity
@Table(name = "GrantConditions")
public class GrantCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private String name;
    private Integer minPeriod;
    private Integer maxPeriod;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;

    @ManyToOne
    @JoinColumn(name = "loanTypeID", referencedColumnName = "ID")
    private LoanType loanType;

    public Integer getId() {
        return id;
    }

    public GrantCondition setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GrantCondition setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getMinPeriod() {
        return minPeriod;
    }

    public GrantCondition setMinPeriod(Integer minPeriod) {
        this.minPeriod = minPeriod;
        return this;
    }

    public Integer getMaxPeriod() {
        return maxPeriod;
    }

    public GrantCondition setMaxPeriod(Integer maxPeriod) {
        this.maxPeriod = maxPeriod;
        return this;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public GrantCondition setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public GrantCondition setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public GrantCondition setLoanType(LoanType loanType) {
        this.loanType = loanType;
        return this;
    }
}
