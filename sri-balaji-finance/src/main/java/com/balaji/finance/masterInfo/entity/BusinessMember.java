package com.balaji.finance.masterInfo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "businessmembers")
public class BusinessMember {

	private String id;
	private PersonalInfo customerId;
	private PersonalInfo guarantor1;
	private PersonalInfo guarantor2;
	private PersonalInfo guarantor3;
	private PersonalInfo partnerId;
	private LocalDateTime startDate;
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

	@Id
	@Column(name = "ID", length = 255, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMERID")
	public PersonalInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(PersonalInfo customerId) {
		this.customerId = customerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guarantor1")
	public PersonalInfo getGuarantor1() {
		return guarantor1;
	}

	public void setGuarantor1(PersonalInfo guarantor1) {
		this.guarantor1 = guarantor1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guarantor2")
	public PersonalInfo getGuarantor2() {
		return guarantor2;
	}

	public void setGuarantor2(PersonalInfo guarantor2) {
		this.guarantor2 = guarantor2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guarantor3")
	public PersonalInfo getGuarantor3() {
		return guarantor3;
	}

	public void setGuarantor3(PersonalInfo guarantor3) {
		this.guarantor3 = guarantor3;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partnerid")
	public PersonalInfo getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(PersonalInfo partnerId) {
		this.partnerId = partnerId;
	}

	@Column(name = "STARTDATE")
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	@Column(name = "ENDDATE")
	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	@Column(name = "AMOUNT")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "DURATION")
	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Column(name = "INTEREST")
	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	@Column(name = "INSTALLMENT")
	public Double getInstallment() {
		return installment;
	}

	public void setInstallment(Double installment) {
		this.installment = installment;
	}

	@Column(name = "SECURITY", length = 255)
	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	@Column(name = "STATUS")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "PAIDINSTALLMENTS")
	public Integer getPaidInstallments() {
		return paidInstallments;
	}

	public void setPaidInstallments(Integer paidInstallments) {
		this.paidInstallments = paidInstallments;
	}

	@Column(name = "PARTPRINCIPAL")
	public Integer getPartPrincipal() {
		return partPrincipal;
	}

	public void setPartPrincipal(Integer partPrincipal) {
		this.partPrincipal = partPrincipal;
	}

	@Column(name = "PARTINTEREST")
	public Integer getPartInterest() {
		return partInterest;
	}

	public void setPartInterest(Integer partInterest) {
		this.partInterest = partInterest;
	}

	@Column(name = "UNPAIDLATEFEE")
	public Integer getUnpaidLateFee() {
		return unpaidLateFee;
	}

	public void setUnpaidLateFee(Integer unpaidLateFee) {
		this.unpaidLateFee = unpaidLateFee;
	}

	@Column(name = "CHEQUEREMINDER")
	public boolean isChequeReminder() {
		return chequeReminder;
	}

	public void setChequeReminder(boolean chequeReminder) {
		this.chequeReminder = chequeReminder;
	}

	@Column(name = "BUSINESSID", length = 255)
	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusinessMember other = (BusinessMember) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BusinessMember [id=" + id + "]";
	}

}
