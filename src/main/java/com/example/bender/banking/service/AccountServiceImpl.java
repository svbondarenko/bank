package com.example.bender.banking.service;


import com.example.bender.banking.dao.AccountRepository;
import com.example.bender.banking.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.locks.Lock;

@Service
public class AccountServiceImpl implements AccountService {

    private final Random number = new Random(123L);
    @Autowired
    private AccountRepository accountRepository;

    private void transferAmount(BankAccount from, BankAccount to, double amount) throws InterruptedException {

        while (true) {
            Lock fromLock = from.getLock();
            Lock toLock = to.getLock();
            if (fromLock.tryLock()) {
                try {
                    if (toLock.tryLock()) {
                        try {
                            if (amount > from.getBalanceAmount()) {
                                throw new IllegalArgumentException(
                                        "Transfer cannot be completed");
                            }
                            to.setBalanceAmount(to.getBalanceAmount() + amount);
                            from.setBalanceAmount(from.getBalanceAmount() - amount);
                            break;
                        } finally {
                            toLock.unlock();
                        }
                    }
                } finally {
                    fromLock.unlock();
                }
            }
            int n = number.nextInt(1000);
            int TIME = 1000 + n; // 1 second + random delay to prevent livelock
            Thread.sleep(TIME);
        }

    }


    /*
     * Used for transfer money from one account to another
     * @param from Account to get amount from
     * @param to Account to put amount
     * @param amount money amount
     */
    @Transactional
    public void initiateTransfer(final BankAccount from,
                                 final BankAccount to, final double amount) {
        Thread transfer = new Thread(new Runnable() {
            public void run() {
                try {
                    transferAmount(from, to, amount);
                    accountRepository.save(from);
                    accountRepository.save(to);
                } catch (InterruptedException e) {
                    //do something

                }
            }
        });
        transfer.start();
    }
}
