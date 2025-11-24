package com.balaji.finance.util.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FinanceController {

	@GetMapping("/interestCalculator")
	public ResponseEntity<?> getInterest(@RequestParam double amount, @RequestParam double rate) {

		// Validation
		if (amount <= 0) {
			return ResponseEntity.badRequest().body("Amount must be greater than 0");
		}

		if (rate <= 0) {
			return ResponseEntity.badRequest().body("Rate must be greater than 0");
		}

		double interest = amount * (rate / 100);

		return ResponseEntity.ok(interest);
	}

}
