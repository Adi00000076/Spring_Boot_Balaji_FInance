package com.balaji.finance.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonalSequenceService {

	@Autowired
	private JdbcTemplate jdbc;

	public Long getNextCustomerSeqId() {
		jdbc.update("INSERT INTO personal_customer_sequence_table VALUES ()");
		return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
	}

	public Long getNextPartnerSeqId() {
		jdbc.update("INSERT INTO personal_Partner_sequence_table VALUES ()");
		return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
	}

	public Long getNextEmployeeSeqId() {
		jdbc.update("INSERT INTO personal_employee_sequence_table VALUES ()");
		return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
	}

	public Long getNextVendorSeqId() {
		jdbc.update("INSERT INTO personal_vendor_sequence_table VALUES ()");
		return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
	}

	
}
