package com.example.bender.banking.domain;

import javax.persistence.*;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private double balanceAmount;  // Total amount in bank account

    public BankAccount() {
    }


    public BankAccount(double balance) {
        this.balanceAmount = balance;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public BankAccount setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }

    public Integer getId() {
        return id;
    }
}
