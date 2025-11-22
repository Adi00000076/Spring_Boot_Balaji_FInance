package com.balaji.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.balaji.finance.entity.Users;
import com.balaji.finance.pojo.AddUserReqPojo;
import com.balaji.finance.repo.UserRepo;

@Service
public class UsersService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String addUser(AddUserReqPojo addUserReqPojo) {

		Users userByName = userRepo.findByName(addUserReqPojo.getName());

		if (userByName == null) {
			
			System.out.println(addUserReqPojo.getName());
			System.out.println(addUserReqPojo.getPassword());

			Users user = new Users();
			user.setName(addUserReqPojo.getName());
			user.setPassword(passwordEncoder.encode(addUserReqPojo.getPassword()));

			userRepo.save(user);

			return "SuccessFully Saved";

		} else {

			return "UserName Alredy Exists";
		}

	}

}
