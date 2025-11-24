package com.balaji.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.finance.dto.PersonalInfoDto;
import com.balaji.finance.masterInfo.entity.Users;
import com.balaji.finance.masterInfo.service.UsersService;
import com.balaji.finance.pojo.AddUserReqPojo;
import com.balaji.finance.pojo.ErrorResponse;

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
	
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deletePersonalInfoTemplate(@PathVariable("id") Integer id) {

		String response = usersService.deletePersonalInfoDto(id);

		return ResponseEntity.ok().body(response);
	}

	
	@GetMapping("/findAllUsers")
	public ResponseEntity<List<Users>> findAll() {

		List<Users> all = usersService.findAll();

		return ResponseEntity.ok().body(all);
	}

}
