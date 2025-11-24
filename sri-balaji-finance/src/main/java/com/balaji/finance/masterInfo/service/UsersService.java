package com.balaji.finance.masterInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.balaji.finance.masterInfo.entity.PersonalInfo;
import com.balaji.finance.masterInfo.entity.Users;
import com.balaji.finance.masterInfo.repo.UserRepo;
import com.balaji.finance.pojo.AddUserReqPojo;

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

	public List<Users> findAll() {
		userRepo.findAll();// TODO Auto-generated method stub
		return null;
	}

	public String deletePersonalInfoDto(Integer id) {

		Optional<Users> users = userRepo.findById(id);

		if (users.isPresent()) {

			userRepo.delete(users.get());

			return "Sucessfully Deleted " + users.get().getName();

		} else {

			return "Record Not Found ";

		}

	}

}
