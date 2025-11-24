package com.balaji.finance.util.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DateController {

	@GetMapping("/end-date")
	public ResponseEntity<?> getEndDate(@RequestParam String startDate, @RequestParam int daysToAdd) {

		// Validate days
		if (daysToAdd < 0) {
			return ResponseEntity.badRequest().body("Days to add must be zero or positive");
		}

		// Validate and parse date safely
		LocalDate start;
		try {
			start = LocalDate.parse(startDate); // expects: YYYY-MM-DD
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD");
		}

		LocalDate endDate = start.plusDays(daysToAdd);

		return ResponseEntity.ok(endDate);
	}

}
