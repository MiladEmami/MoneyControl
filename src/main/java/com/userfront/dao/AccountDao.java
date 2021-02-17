package com.userfront.dao;

import com.userfront.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<Account,Long> {

    Account findByAccountNumber (int accountNumber);
}
