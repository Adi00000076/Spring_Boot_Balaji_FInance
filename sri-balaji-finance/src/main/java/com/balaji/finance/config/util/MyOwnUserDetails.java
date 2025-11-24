package com.balaji.finance.config.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.balaji.finance.masterInfo.entity.Users;
import com.balaji.finance.masterInfo.repo.UserRepo;

@Service
public class MyOwnUserDetails implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Users user = userRepo.findByName(username);
		String role = user.getRole() == null ? "USER" : user.getRole();

		return User.builder().username(user.getName()).password(user.getPassword()).roles(role).build();

	}

}
