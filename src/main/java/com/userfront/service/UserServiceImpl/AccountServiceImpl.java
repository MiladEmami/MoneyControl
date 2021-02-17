package com.userfront.service.UserServiceImpl;

import com.userfront.dao.AccountDao;
import com.userfront.dao.SavingsAccountDao;
import com.userfront.domain.*;
import com.userfront.service.AccountService;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    private static int nextAccountNumber = 11223145;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public Account createAccount() {
        Account account = new Account();
        account.setAccountBalance(new BigDecimal(0.0));
        account.setAccountNumber(accountGen());

        accountDao.save(account);

        return accountDao.findByAccountNumber(account.getAccountNumber());
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }

    @Override
    public void deposit(String description, String accountType, double amount, Principal principal) {
        User user = userService.findByUsername(principal.getName());

        Account account = user.getAccount();
        account.setAccountBalance(account.getAccountBalance().add(new BigDecimal(amount)));
        accountDao.save(account);

        Date date = new Date();
        Income income = new Income(date, description, accountType, amount, account);
        transactionService.saveDeposit(income);
    }

    @Override
    public void withdraw(String description, String accountType, double amount, Principal principal) {
        User user = userService.findByUsername(principal.getName());

        Account account = user.getAccount();
        account.setAccountBalance(account.getAccountBalance().subtract(new BigDecimal(amount)));
        accountDao.save(account);

        Date date = new Date();
        Cost cost = new Cost(date, description, accountType, amount, account);
        transactionService.saveWithdraw(cost);
    }


    private int accountGen() {
        return ++nextAccountNumber;
    }
}
