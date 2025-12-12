package com.balaji.finance.masterInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.finance.dto.BusinessMemberDto;
import com.balaji.finance.masterInfo.service.BusinessMemberService;
import com.balaji.finance.pojo.BusinessMemberAutoCompletePojo;

@RestController
@RequestMapping("/BusinessMember")
public class BusinessMemberController {

	@Autowired
	private BusinessMemberService businessMemberService;

	@PostMapping("/update/{loanType}")
	public ResponseEntity<String> update(@RequestBody BusinessMemberDto businessMemberDto,
			@PathVariable("loanType") String loanType) {

		String response = null;

		if (businessMemberDto.getId() == null || businessMemberDto.getId().isBlank()) {
			response = businessMemberService.saveBusinessMember(businessMemberDto, loanType);
		} else {
			response = businessMemberService.updateBusinessMember(businessMemberDto);
		}

		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {

		String response = businessMemberService.deleteBusinessMember(id);

		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<BusinessMemberDto> findById(@PathVariable("id") String id) {

		BusinessMemberDto businessMemberDto = businessMemberService.findById(id);

		return ResponseEntity.ok().body(businessMemberDto);
	}

	@GetMapping("/findAll/{loanType}")
	public ResponseEntity<List<BusinessMemberDto>> findAll(@PathVariable("loanType") String loanType) {

		List<BusinessMemberDto> all = businessMemberService.findAll(loanType);

		return ResponseEntity.ok().body(all);
	}

	@GetMapping("/loanDetailsAutoComplete/{loanType}")
	public ResponseEntity<List<BusinessMemberAutoCompletePojo>> loanDetailsAutoComplete(@RequestParam String q,
			@PathVariable("loanType") String loanType) {

		List<BusinessMemberAutoCompletePojo> all = businessMemberService.businessMemberAutoComplete(q, loanType);

		return ResponseEntity.ok().body(all);

	}

}
