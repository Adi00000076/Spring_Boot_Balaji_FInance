package com.balaji.finance.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BusinessMemersSequenceService {

	@Autowired
	private JdbcTemplate jdbc;

	public Long getNextBusinessMemberDailyFinanceSequenceSeqId() {
		jdbc.update("INSERT INTO business_member_daily_finance_sequence VALUES ()");
		return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
	}

	public Long getNextBusinessMemberMonthlyFinanceSequenceSeqId() {
		jdbc.update("INSERT INTO business_member_monthly_finance_sequence VALUES ()");
		return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
	}

}
