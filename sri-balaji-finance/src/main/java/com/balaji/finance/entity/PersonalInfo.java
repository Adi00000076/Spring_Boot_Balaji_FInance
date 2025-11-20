package com.balaji.finance.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PersonalInfo")
public class PersonalInfo {

	@Id
	private String id;

	private String firstname;
	private String lastname;
	private String gender;
	private String fathername;
	private String address;
	private String mobile;
	private String phone;
	private String category;
	private String reference;
	private String idproof;

	private Boolean disable;

	private Double shares;
	private Double loanlimit;

	private String address2;
	private String mobile2;
	private String phone2;
	private String oldid;
	private String age;
	private String occupation;
	private String spouse;

	private Boolean bussinessexemption;
	private String introname;

	// ---------- GETTERS & SETTERS ----------

	public String getFirstname() {
		return firstname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getIdproof() {
		return idproof;
	}

	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public Double getShares() {
		return shares;
	}

	public void setShares(Double shares) {
		this.shares = shares;
	}

	public Double getLoanlimit() {
		return loanlimit;
	}

	public void setLoanlimit(Double loanlimit) {
		this.loanlimit = loanlimit;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getOldid() {
		return oldid;
	}

	public void setOldid(String oldid) {
		this.oldid = oldid;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSpouse() {
		return spouse;
	}

	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	public Boolean getBussinessexemption() {
		return bussinessexemption;
	}

	public void setBussinessexemption(Boolean bussinessexemption) {
		this.bussinessexemption = bussinessexemption;
	}

	public String getIntroname() {
		return introname;
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
		PersonalInfo other = (PersonalInfo) obj;
		return Objects.equals(id, other.id);
	}

	public void setIntroname(String introname) {
		this.introname = introname;
	}

}
