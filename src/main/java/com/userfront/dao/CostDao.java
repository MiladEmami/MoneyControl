package com.userfront.dao;

import com.userfront.domain.Cost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostDao extends CrudRepository<Cost, Long> {

    List<Cost> findAll();
}
