package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.Cost;
import com.userfront.domain.Income;
import com.userfront.domain.Recipient;
import com.userfront.domain.User;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private IncomeDao incomeDao;

    @Autowired
    private CostDao costDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Override
    public List<Cost> findCostList(String username) {
        User user = userService.findByUsername(username);
        List<Cost> incomeList = user.getAccount().getCostList();

        return incomeList;
    }

    @Override
    public List<Income> findIncomeList(String username) {
        User user = userService.findByUsername(username);
        List<Income> incomeList = user.getAccount().getIncomeList();

        return incomeList;
    }

    @Override
    public void saveDeposit(Income income) {
        incomeDao.save(income);
    }

    @Override
    public void saveWithdraw(Cost cost) {
        costDao.save(cost);
    }

}
