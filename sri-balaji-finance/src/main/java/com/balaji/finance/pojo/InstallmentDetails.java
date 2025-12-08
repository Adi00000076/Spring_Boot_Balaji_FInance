package com.balaji.finance.pojo;

public class InstallmentDetails {

	private long installmentNumber;
	private String dueDate;
	private String lateFeeDate;
	private double installmentAmount;
	private double lateFee;
	private double total;
	private double paid;

	// Getters and Setters

	public long getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(long installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getLateFeeDate() {
		return lateFeeDate;
	}

	public void setLateFeeDate(String lateFeeDate) {
		this.lateFeeDate = lateFeeDate;
	}

	public double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(double installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}
}
