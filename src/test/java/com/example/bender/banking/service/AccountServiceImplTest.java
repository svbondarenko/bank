package com.example.bender.banking.service;

import com.example.bender.banking.app.Application;
import com.example.bender.banking.dao.AccountRepository;
import com.example.bender.banking.domain.BankAccount;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountServiceImpl;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void test() {
        BankAccount bankAccount1 = accountRepository.save(new BankAccount().setBalanceAmount(100));
        BankAccount bankAccount2 = accountRepository.save(new BankAccount().setBalanceAmount(100));
        accountServiceImpl.initiateTransfer(bankAccount1, bankAccount2, 30);
        accountServiceImpl.initiateTransfer(bankAccount2, bankAccount1, 70);
        Assert.assertEquals(140, bankAccount1.getBalanceAmount(), 0);
        Assert.assertEquals(60, bankAccount2.getBalanceAmount(), 0);
    }
}
