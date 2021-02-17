package com.userfront.dao;

import java.util.List;

import com.userfront.domain.Income;
import org.springframework.data.repository.CrudRepository;

public interface IncomeDao extends CrudRepository<Income, Long> {

    List<Income> findAll();
}
