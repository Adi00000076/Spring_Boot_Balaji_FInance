package com.balaji.finance.masterInfo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.finance.dto.PersonalInfoAutoCompletePojo;
import com.balaji.finance.dto.PersonalInfoDto;
import com.balaji.finance.masterInfo.entity.PersonalInfo;
import com.balaji.finance.masterInfo.repo.PersonalInfoRepository;
import com.balaji.finance.util.PersonalSequenceService;

@Service
public class PersonalInfoService {

	@Autowired
	private PersonalInfoRepository personalInfoRepository;

	@Autowired
	private PersonalSequenceService personalSequenceService;

	public String generateId(String type) {

		String prefix;
		long seq = 0;
		switch (type) {
		case "PARTNER":
			prefix = "P";
			seq = personalSequenceService.getNextPartnerSeqId();
			break;

		case "CUSTOMER":
			prefix = "C";
			seq = personalSequenceService.getNextCustomerSeqId();
			break;

		case "EMPLOYEE":
			prefix = "E";
			seq = personalSequenceService.getNextEmployeeSeqId();
			break;

		case "VENDOR":
			prefix = "V";
			seq = personalSequenceService.getNextVendorSeqId();
			break;

		default:
			throw new IllegalArgumentException("Unknown type: " + type);
		}

		return prefix + "" + seq;
	}

	// create
	public PersonalInfoDto createPersonalInfoDto(String type) {

		PersonalInfoDto personalInfoDto = new PersonalInfoDto();

		return personalInfoDto;

	}

	// create
	public String savePersonalInfoDto(PersonalInfoDto personalInfoDto,String type) {

		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setId(generateId(type));
		
		
		personalInfo.setFirstname(personalInfoDto.getFirstname());
		personalInfo.setLastname(personalInfoDto.getLastname());
		personalInfo.setGender(personalInfoDto.getGender());
		personalInfo.setAge(personalInfoDto.getAge());
		
		
		personalInfo.setFathername(personalInfoDto.getFathername());
		personalInfo.setSpouse(personalInfoDto.getSpouse());

		personalInfo.setOccupation(personalInfoDto.getOccupation());
		
		
		personalInfo.setAddress(personalInfoDto.getAddress());
		personalInfo.setMobile(personalInfoDto.getMobile());
		personalInfo.setPhone(personalInfoDto.getPhone());
		personalInfo.setAddress2(personalInfoDto.getAddress2());
		personalInfo.setMobile2(personalInfoDto.getMobile2());
		personalInfo.setPhone2(personalInfoDto.getPhone2());
		
		
		personalInfo.setReference(personalInfoDto.getReference());
		personalInfo.setIdproof(personalInfoDto.getIdproof());
		personalInfo.setIdProoftype(personalInfoDto.getIdprooftype());
		
		personalInfo.setShares(personalInfoDto.getShares());
		personalInfo.setLoanlimit(personalInfoDto.getLoanlimit());

		personalInfo.setBussinessexemption(personalInfoDto.isBussinessexemption());
		personalInfo.setIntroname(personalInfoDto.getIntroname());

		personalInfo.setOldid(personalInfoDto.getOldid());
		personalInfo.setCategory(personalInfoDto.getCategory());
		personalInfo.setDisable(personalInfoDto.isDisable());
		
		
		personalInfoRepository.save(personalInfo);

		return "Sucessfully Saved ";
	}

	// update
	public String updatePersonalInfoDto(PersonalInfoDto personalInfoDto) {

		Optional<PersonalInfo> personalInfoInDb = personalInfoRepository.findById(personalInfoDto.getId());

		if (personalInfoInDb.isPresent()) {

			PersonalInfo personalInfo = personalInfoInDb.get();
			
			personalInfo.setFirstname(personalInfoDto.getFirstname());
			personalInfo.setLastname(personalInfoDto.getLastname());
			personalInfo.setGender(personalInfoDto.getGender());
			personalInfo.setAge(personalInfoDto.getAge());
			
			
			personalInfo.setFathername(personalInfoDto.getFathername());
			personalInfo.setSpouse(personalInfoDto.getSpouse());

			personalInfo.setOccupation(personalInfoDto.getOccupation());
			
			
			personalInfo.setAddress(personalInfoDto.getAddress());
			personalInfo.setMobile(personalInfoDto.getMobile());
			personalInfo.setPhone(personalInfoDto.getPhone());
			personalInfo.setAddress2(personalInfoDto.getAddress2());
			personalInfo.setMobile2(personalInfoDto.getMobile2());
			personalInfo.setPhone2(personalInfoDto.getPhone2());
			
			
			personalInfo.setReference(personalInfoDto.getReference());
			personalInfo.setIdproof(personalInfoDto.getIdproof());
			personalInfo.setIdProoftype(personalInfoDto.getIdprooftype());
			
			personalInfo.setShares(personalInfoDto.getShares());
			personalInfo.setLoanlimit(personalInfoDto.getLoanlimit());

			personalInfo.setBussinessexemption(personalInfoDto.isBussinessexemption());
			personalInfo.setIntroname(personalInfoDto.getIntroname());

			personalInfo.setOldid(personalInfoDto.getOldid());
			personalInfo.setCategory(personalInfoDto.getCategory());
			personalInfo.setDisable(personalInfoDto.isDisable());
			
			
			
			personalInfoRepository.save(personalInfo);

			return "Sucessfully Updated ";

		} else {

			return "Record Not Found ";

		}

	}

	// delete
	public String deletePersonalInfoDto(String id) {

		Optional<PersonalInfo> personalInfoInDb = personalInfoRepository.findById(id);

		if (personalInfoInDb.isPresent()) {

			PersonalInfo personalInfo = personalInfoInDb.get();
			personalInfo.setDisable(true);

			personalInfoRepository.save(personalInfo);

			return "Sucessfully Deleted " + personalInfo.getId();

		} else {

			return "Record Not Found " + id;

		}

	}

	// findAll
	public List<PersonalInfoDto> findAll() {

		List<PersonalInfo> allPersonalInfoList = personalInfoRepository.findAllActiveRecords(false);

		List<PersonalInfoDto> toBeReturnedDtoList = new ArrayList<PersonalInfoDto>();

		allPersonalInfoList.stream().forEach(p -> {

			PersonalInfoDto personalInfoDto = new PersonalInfoDto();
			personalInfoDto.setId(p.getId());
			
			
			personalInfoDto.setFirstname(p.getFirstname());
			personalInfoDto.setLastname(p.getLastname());
			personalInfoDto.setGender(p.getGender());
			personalInfoDto.setAge(p.getAge());
			
			
			personalInfoDto.setFathername(p.getFathername());
			personalInfoDto.setSpouse(p.getSpouse());

			personalInfoDto.setOccupation(p.getOccupation());
			
			
			personalInfoDto.setAddress(p.getAddress());
			personalInfoDto.setMobile(p.getMobile());
			personalInfoDto.setPhone(p.getPhone());
			personalInfoDto.setAddress2(p.getAddress2());
			personalInfoDto.setMobile2(p.getMobile2());
			personalInfoDto.setPhone2(p.getPhone2());
			
			
			personalInfoDto.setReference(p.getReference());
			personalInfoDto.setIdproof(p.getIdproof());
			personalInfoDto.setIdprooftype(p.getIdProoftype());
			
			personalInfoDto.setShares(p.getShares());
			personalInfoDto.setLoanlimit(p.getLoanlimit());

			personalInfoDto.setBussinessexemption(p.isBussinessexemption());
			personalInfoDto.setIntroname(p.getIntroname());

			personalInfoDto.setOldid(p.getOldid());
			personalInfoDto.setCategory(p.getCategory());
			personalInfoDto.setDisable(p.isDisable());
			
			
			toBeReturnedDtoList.add(personalInfoDto);

		});

		return toBeReturnedDtoList;
	}

	
	// findAll
	public PersonalInfoDto findById(String id) {

		Optional<PersonalInfo> personalInfo = personalInfoRepository.findById(id);

		if (personalInfo.isPresent()) {

			PersonalInfo personalInfoDbObject = personalInfo.get();



			PersonalInfoDto personalInfoDto = new PersonalInfoDto();
			personalInfoDto.setId(personalInfoDbObject.getId());
			
			
			personalInfoDto.setFirstname(personalInfoDbObject.getFirstname());
			personalInfoDto.setLastname(personalInfoDbObject.getLastname());
			personalInfoDto.setGender(personalInfoDbObject.getGender());
			personalInfoDto.setAge(personalInfoDbObject.getAge());
			
			
			personalInfoDto.setFathername(personalInfoDbObject.getFathername());
			personalInfoDto.setSpouse(personalInfoDbObject.getSpouse());

			personalInfoDto.setOccupation(personalInfoDbObject.getOccupation());
			
			
			personalInfoDto.setAddress(personalInfoDbObject.getAddress());
			personalInfoDto.setMobile(personalInfoDbObject.getMobile());
			personalInfoDto.setPhone(personalInfoDbObject.getPhone());
			personalInfoDto.setAddress2(personalInfoDbObject.getAddress2());
			personalInfoDto.setMobile2(personalInfoDbObject.getMobile2());
			personalInfoDto.setPhone2(personalInfoDbObject.getPhone2());
			
			
			personalInfoDto.setReference(personalInfoDbObject.getReference());
			personalInfoDto.setIdproof(personalInfoDbObject.getIdproof());
			personalInfoDto.setIdprooftype(personalInfoDbObject.getIdProoftype());
			
			personalInfoDto.setShares(personalInfoDbObject.getShares());
			personalInfoDto.setLoanlimit(personalInfoDbObject.getLoanlimit());

			personalInfoDto.setBussinessexemption(personalInfoDbObject.isBussinessexemption());
			personalInfoDto.setIntroname(personalInfoDbObject.getIntroname());

			personalInfoDto.setOldid(personalInfoDbObject.getOldid());
			personalInfoDto.setCategory(personalInfoDbObject.getCategory());
			personalInfoDto.setDisable(personalInfoDbObject.isDisable());

			return personalInfoDto;
		
		} else {

			return null;

		}

	}

	public List<PersonalInfoAutoCompletePojo> autocomplete(String keyword) {

		List<PersonalInfo> allPersonalInfoList = personalInfoRepository.personalInfoAutoComplete(false, keyword,
				Arrays.asList("CUSTOMER", "PARTNER"));

		List<PersonalInfoAutoCompletePojo> toBeReturnedDtoList = new ArrayList<PersonalInfoAutoCompletePojo>();

		allPersonalInfoList.stream().forEach(p -> {

			PersonalInfoAutoCompletePojo personalInfoAutoCompletePojo = new PersonalInfoAutoCompletePojo();
			personalInfoAutoCompletePojo.setId(p.getId());

			personalInfoAutoCompletePojo.setFirstname(p.getFirstname());
			personalInfoAutoCompletePojo.setLastname(p.getLastname());
			personalInfoAutoCompletePojo.setGender(p.getGender());

			toBeReturnedDtoList.add(personalInfoAutoCompletePojo);

		});

		return toBeReturnedDtoList;
	}
}
