package com.balaji.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.finance.config.util.JwtUtil;
import com.balaji.finance.pojo.ErrorResponse;
import com.balaji.finance.pojo.LoginReqPojo;
import com.balaji.finance.pojo.LoginResponse;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginReqPojo loginReqPojo) {

		try {

			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginReqPojo.getName(), loginReqPojo.getPassword()));

			String token = jwtUtil.generateToken(loginReqPojo.getName());

			return ResponseEntity.ok(new LoginResponse("Login success", token));

		} catch (BadCredentialsException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorResponse("Invalid username or password"));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("User does not exist"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorResponse("Login failed due to server error"));
		}

	}

}
