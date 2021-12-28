package com.dotin.model.data;

import javax.persistence.*;

/**
 * @author : Bahar Zolfaghari
 **/
@Entity
@Table(name = "LoanTypes")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private String name;
    private Integer interestRate;

    public Integer getId() {
        return id;
    }

    public LoanType setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LoanType setName(String name) {
        this.name = name;
        return this;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public LoanType setInterestRate(int interestRate) {
        this.interestRate = interestRate;
        return this;
    }
}
