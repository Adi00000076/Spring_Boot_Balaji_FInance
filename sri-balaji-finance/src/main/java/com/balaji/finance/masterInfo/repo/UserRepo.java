package com.balaji.finance.masterInfo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balaji.finance.masterInfo.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	public Users findByName(String name);
	
	
	
}
