package com.userfront.service;

import java.security.Principal;

import com.userfront.domain.Account;
import com.userfront.domain.SavingsAccount;

public interface AccountService {
    Account createAccount();

    SavingsAccount createSavingsAccount();

    void deposit(String description, String accountType, double amount, Principal principal);

    void withdraw(String type, String accountType, double amount, Principal principal);
}
