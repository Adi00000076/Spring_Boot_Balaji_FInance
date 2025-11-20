package com.balaji.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.finance.dto.PersonalInfoDto;
import com.balaji.finance.service.PersonalInfoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/PersonalInfo")
public class PersonalInfoController {

	@Autowired
	private PersonalInfoService personalInfoService;

	@GetMapping("/createNewPersonalInfoTemplate/{personaType}")
	public ResponseEntity<PersonalInfoDto> createNewPersonalInfoTemplate(
			@PathVariable("personType") String personType) {

		PersonalInfoDto personalInfoDto = personalInfoService.createPersonalInfoDto(personType);

		return ResponseEntity.ok().body(personalInfoDto);
	}

	@PostMapping("/updatePersonalInfo")
	public ResponseEntity<String> updatePersonalInfoTemplate(@RequestBody PersonalInfoDto personalInfoDto) {

		String response = personalInfoService.updatePersonalInfoDto(personalInfoDto);

		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping("/deletePersonalInfo")
	public ResponseEntity<String> deletePersonalInfoTemplate(@RequestBody PersonalInfoDto personalInfoDto) {

		String response = personalInfoService.deletePersonalInfoDto(personalInfoDto);

		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/findPersonalInfoById/{id}")
	public ResponseEntity<PersonalInfoDto> findPersonalInfoById(@PathVariable("id") String id) {

		PersonalInfoDto personalInfoDto = personalInfoService.findById(id);

		return ResponseEntity.ok().body(personalInfoDto);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<PersonalInfoDto>> findAll() {

		List<PersonalInfoDto> all = personalInfoService.findAll();

		return ResponseEntity.ok().body(all);
	}

}
