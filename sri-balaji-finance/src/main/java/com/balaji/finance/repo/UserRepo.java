package com.balaji.finance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balaji.finance.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	public Users findByName(String name);
	
	
	
}
