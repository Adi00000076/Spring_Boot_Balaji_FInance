package com.balaji.finance.masterInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.finance.masterInfo.service.LoanInstallmentPaymentService;
import com.balaji.finance.pojo.LoanInformation;

@RestController
public class LoanViewController {

	@Autowired
	private LoanInstallmentPaymentService loanInstallmentPaymentService;

	@GetMapping("/loadMFLoanInformation/{loanId}")
	public ResponseEntity<LoanInformation> loadMFLoanInformation(@PathVariable("id") String loanId) {
		LoanInformation mfLoanPaidInfo = loanInstallmentPaymentService.loadMFLoanPaidInfo(loanId);

		return ResponseEntity.ok().body(mfLoanPaidInfo);
	}

}
