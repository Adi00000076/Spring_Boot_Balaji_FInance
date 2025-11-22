package com.balaji.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.finance.pojo.AddUserReqPojo;
import com.balaji.finance.pojo.ErrorResponse;
import com.balaji.finance.service.UsersService;

@RestController
public class UserController {

	@Autowired
	private UsersService usersService;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody  AddUserReqPojo addUserReqPojo) {

		try {
			String message = usersService.addUser(addUserReqPojo);

			if (message.equalsIgnoreCase("UserName Alredy Exists")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(new ErrorResponse("UserName Alredy Exists"));
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Successfully Registered");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("User Added Failed"));
		}

	}

}
