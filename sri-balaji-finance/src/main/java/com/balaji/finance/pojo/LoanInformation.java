package com.balaji.finance.pojo;

import java.util.ArrayList;
import java.util.List;

public class LoanInformation {

	private String accountNo;
	private String partnerName;
	private String guarantorName;

	private Double loanAmount;
	private Double installmentAmount;

	private String periodFrom;
	private String periodTo;

	private String date;
	private Boolean paid;
	private Double balance;
	private Double amountPaid;
	private Double lateFee;

	private Double pendingLateFee;
	private Double dueAmount;

	private List<InstallmentDetails> installmentDetailsList = new ArrayList<InstallmentDetails>();

	// Getters and Setters

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getGuarantorName() {
		return guarantorName;
	}

	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(Double installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public String getPeriodFrom() {
		return periodFrom;
	}

	public void setPeriodFrom(String periodFrom) {
		this.periodFrom = periodFrom;
	}

	public String getPeriodTo() {
		return periodTo;
	}

	public void setPeriodTo(String periodTo) {
		this.periodTo = periodTo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getLateFee() {
		return lateFee;
	}

	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}

	public Double getPendingLateFee() {
		return pendingLateFee;
	}

	public void setPendingLateFee(Double pendingLateFee) {
		this.pendingLateFee = pendingLateFee;
	}

	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public List<InstallmentDetails> getInstallmentDetailsList() {
		return installmentDetailsList;
	}

	public void setInstallmentDetailsList(List<InstallmentDetails> installmentDetailsList) {
		this.installmentDetailsList = installmentDetailsList;
	}

}
