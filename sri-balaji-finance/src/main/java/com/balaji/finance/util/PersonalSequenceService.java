package com.balaji.finance.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonalSequenceService {

	@Autowired
	private JdbcTemplate jdbc;

	public Long getNextId() {
		jdbc.update("INSERT INTO personal_sequence_table VALUES ()");
		return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
	}

}
