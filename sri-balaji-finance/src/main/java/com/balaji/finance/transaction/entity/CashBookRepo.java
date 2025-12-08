package com.balaji.finance.transaction.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashBookRepo extends JpaRepository<CashBook, Double> {

	public List<CashBook> findByAccountNo(String accountNo);

}
