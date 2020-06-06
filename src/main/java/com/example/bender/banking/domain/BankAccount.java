package com.example.bender.banking.domain;

import javax.persistence.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private double balanceAmount;  // Total amount in bank account

    @Transient
    private final Lock lock = new ReentrantLock();

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

    public Lock getLock() {
        return lock;
    }

    public Integer getId() {
        return id;
    }
}
