package com.balaji.finance.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

@Service
public class BusinessMemberDto {

	private String id;
	private String customerId;
	private String guarantor1;
	private String guarantor2;
	private String guarantor3;
	private String partnerId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDate;

	private Double amount;
	private Double duration;
	private Double interest;
	private Double installment;
	private String security;
	private boolean status;
	private Integer paidInstallments;
	private Integer partPrincipal;
	private Integer partInterest;
	private Integer unpaidLateFee;
	private boolean chequeReminder;
	private String businessId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getGuarantor1() {
		return guarantor1;
	}

	public void setGuarantor1(String guarantor1) {
		this.guarantor1 = guarantor1;
	}

	public String getGuarantor2() {
		return guarantor2;
	}

	public void setGuarantor2(String guarantor2) {
		this.guarantor2 = guarantor2;
	}

	public String getGuarantor3() {
		return guarantor3;
	}

	public void setGuarantor3(String guarantor3) {
		this.guarantor3 = guarantor3;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getInstallment() {
		return installment;
	}

	public void setInstallment(Double installment) {
		this.installment = installment;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getPaidInstallments() {
		return paidInstallments;
	}

	public void setPaidInstallments(Integer paidInstallments) {
		this.paidInstallments = paidInstallments;
	}

	public Integer getPartPrincipal() {
		return partPrincipal;
	}

	public void setPartPrincipal(Integer partPrincipal) {
		this.partPrincipal = partPrincipal;
	}

	public Integer getPartInterest() {
		return partInterest;
	}

	public void setPartInterest(Integer partInterest) {
		this.partInterest = partInterest;
	}

	public Integer getUnpaidLateFee() {
		return unpaidLateFee;
	}

	public void setUnpaidLateFee(Integer unpaidLateFee) {
		this.unpaidLateFee = unpaidLateFee;
	}

	public boolean isChequeReminder() {
		return chequeReminder;
	}

	public void setChequeReminder(boolean chequeReminder) {
		this.chequeReminder = chequeReminder;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

}
