package com.balaji.finance.masterInfo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	private String role;

	// Getters and Setters

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
