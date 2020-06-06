package com.example.bender.banking.service;


import com.example.bender.banking.domain.BankAccount;


public interface AccountService {

    void initiateTransfer(final BankAccount from,
                          final BankAccount to, final double amount);
}
