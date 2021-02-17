package com.userfront.service;

import com.userfront.domain.Cost;
import com.userfront.domain.Income;

import java.util.List;

public interface TransactionService {
	List<Income> findIncomeList(String username);

	List<Cost> findCostList(String username);

    void saveDeposit(Income income);

    void saveWithdraw(Cost income);
}
