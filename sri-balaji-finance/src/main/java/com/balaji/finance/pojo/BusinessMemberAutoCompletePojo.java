package com.balaji.finance.pojo;

public class BusinessMemberAutoCompletePojo {

	private String loanId;
	private String customerName;
	private String customerId;

	private String displayString;

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDisplayString() {
		displayString = loanId + "-" + customerName + "-" + customerId;
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}

}
