package com.balaji.finance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.finance.dto.PersonalInfoDto;
import com.balaji.finance.entity.PersonalInfo;
import com.balaji.finance.repo.PersonalInfoRepository;
import com.balaji.finance.util.PersonalSequenceService;

@Service
public class PersonalInfoService {

	@Autowired
	private PersonalInfoRepository personalInfoRepository;

	@Autowired
	private PersonalSequenceService personalSequenceService;

	public String generateId(String type) {

		String prefix;

		switch (type) {
		case "PARTNER":
			prefix = "P";
			break;

		case "CUSTOMER":
			prefix = "C";
			break;

		case "EMPLOYEE":
			prefix = "E";
			break;

		case "VENDOR":
			prefix = "V";
			break;

		default:
			throw new IllegalArgumentException("Unknown type: " + type);
		}

		long seq = personalSequenceService.getNextId();

		return prefix + "" + seq;
	}

	// create
	public PersonalInfoDto createPersonalInfoDto(String type) {

		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setId(generateId(type));

		personalInfoRepository.save(personalInfo);

		PersonalInfoDto personalInfoDto = new PersonalInfoDto();
		personalInfoDto.setId(personalInfo.getId());

		return personalInfoDto;

	}

	// create
	public String savePersonalInfoDto(PersonalInfoDto personalInfoDto) {

		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setFirstname(personalInfoDto.getFirstname());
		personalInfo.setLastname(personalInfoDto.getLastname());
		personalInfo.setGender(personalInfoDto.getGender());
		personalInfo.setFathername(personalInfoDto.getFathername());
		personalInfo.setAddress(personalInfoDto.getAddress());
		personalInfo.setMobile(personalInfoDto.getMobile());
		personalInfo.setPhone(personalInfoDto.getPhone());
		personalInfo.setCategory(personalInfoDto.getCategory());
		personalInfo.setReference(personalInfoDto.getReference());
		personalInfo.setIdproof(personalInfoDto.getIdproof());
		personalInfo.setDisable(personalInfoDto.getDisable());
		personalInfo.setShares(personalInfoDto.getShares());
		personalInfo.setLoanlimit(personalInfoDto.getLoanlimit());

		personalInfo.setAddress2(personalInfoDto.getAddress2());
		personalInfo.setMobile2(personalInfoDto.getMobile2());
		personalInfo.setPhone2(personalInfoDto.getPhone2());
		personalInfo.setOldid(personalInfoDto.getOldid());
		personalInfo.setAge(personalInfoDto.getAge());
		personalInfo.setOccupation(personalInfoDto.getOccupation());
		personalInfo.setSpouse(personalInfoDto.getSpouse());

		personalInfo.setBussinessexemption(personalInfoDto.getBussinessexemption());
		personalInfo.setIntroname(personalInfoDto.getIntroname());

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
			personalInfo.setFathername(personalInfoDto.getFathername());
			personalInfo.setAddress(personalInfoDto.getAddress());
			personalInfo.setMobile(personalInfoDto.getMobile());
			personalInfo.setPhone(personalInfoDto.getPhone());
			personalInfo.setCategory(personalInfoDto.getCategory());
			personalInfo.setReference(personalInfoDto.getReference());
			personalInfo.setIdproof(personalInfoDto.getIdproof());
			personalInfo.setDisable(personalInfoDto.getDisable());
			personalInfo.setShares(personalInfoDto.getShares());
			personalInfo.setLoanlimit(personalInfoDto.getLoanlimit());

			personalInfo.setAddress2(personalInfoDto.getAddress2());
			personalInfo.setMobile2(personalInfoDto.getMobile2());
			personalInfo.setPhone2(personalInfoDto.getPhone2());
			personalInfo.setOldid(personalInfoDto.getOldid());
			personalInfo.setAge(personalInfoDto.getAge());
			personalInfo.setOccupation(personalInfoDto.getOccupation());
			personalInfo.setSpouse(personalInfoDto.getSpouse());

			personalInfo.setBussinessexemption(personalInfoDto.getBussinessexemption());
			personalInfo.setIntroname(personalInfoDto.getIntroname());

			personalInfoRepository.save(personalInfo);

			return "Sucessfully Updated ";

		} else {

			return "Record Not Found ";

		}

	}

	// delete
	public String deletePersonalInfoDto(PersonalInfoDto personalInfoDto) {

		Optional<PersonalInfo> personalInfoInDb = personalInfoRepository.findById(personalInfoDto.getId());

		if (personalInfoInDb.isPresent()) {

			PersonalInfo personalInfo = personalInfoInDb.get();
			personalInfoRepository.delete(personalInfo);

			return "Sucessfully Deleted " + personalInfoDto.getFirstname();

		} else {

			return "Record Not Found " + personalInfoDto.getFirstname();

		}

	}

	// findAll
	public List<PersonalInfoDto> findAll() {

		List<PersonalInfo> allPersonalInfoList = personalInfoRepository.findAll();

		List<PersonalInfoDto> toBeReturnedDtoList = new ArrayList<PersonalInfoDto>();

		allPersonalInfoList.stream().forEach(p -> {

			PersonalInfoDto personalInfoDto = new PersonalInfoDto();
			personalInfoDto.setFirstname(p.getFirstname());
			personalInfoDto.setLastname(p.getLastname());
			personalInfoDto.setGender(p.getGender());
			personalInfoDto.setFathername(p.getFathername());
			personalInfoDto.setAddress(p.getAddress());
			personalInfoDto.setMobile(p.getMobile());
			personalInfoDto.setPhone(p.getPhone());
			personalInfoDto.setCategory(p.getCategory());
			personalInfoDto.setReference(p.getReference());
			personalInfoDto.setIdproof(p.getIdproof());
			personalInfoDto.setDisable(p.getDisable());
			personalInfoDto.setShares(p.getShares());
			personalInfoDto.setLoanlimit(p.getLoanlimit());

			personalInfoDto.setAddress2(p.getAddress2());
			personalInfoDto.setMobile2(p.getMobile2());
			personalInfoDto.setPhone2(p.getPhone2());
			personalInfoDto.setOldid(p.getOldid());
			personalInfoDto.setAge(p.getAge());
			personalInfoDto.setOccupation(p.getOccupation());
			personalInfoDto.setSpouse(p.getSpouse());

			personalInfoDto.setBussinessexemption(p.getBussinessexemption());
			personalInfoDto.setIntroname(p.getIntroname());

			toBeReturnedDtoList.add(personalInfoDto);

		});

		return toBeReturnedDtoList;
	}

	// findBy
	// findAll
	public PersonalInfoDto findById(String id) {

		Optional<PersonalInfo> personalInfo = personalInfoRepository.findById(id);

		if (personalInfo.isPresent()) {

			PersonalInfo personalInfoDbObject = personalInfo.get();

			PersonalInfoDto personalInfoDto = new PersonalInfoDto();
			personalInfoDto.setFirstname(personalInfoDbObject.getFirstname());
			personalInfoDto.setLastname(personalInfoDbObject.getLastname());
			personalInfoDto.setGender(personalInfoDbObject.getGender());
			personalInfoDto.setFathername(personalInfoDbObject.getFathername());
			personalInfoDto.setAddress(personalInfoDbObject.getAddress());
			personalInfoDto.setMobile(personalInfoDbObject.getMobile());
			personalInfoDto.setPhone(personalInfoDbObject.getPhone());
			personalInfoDto.setCategory(personalInfoDbObject.getCategory());
			personalInfoDto.setReference(personalInfoDbObject.getReference());
			personalInfoDto.setIdproof(personalInfoDbObject.getIdproof());
			personalInfoDto.setDisable(personalInfoDbObject.getDisable());
			personalInfoDto.setShares(personalInfoDbObject.getShares());
			personalInfoDto.setLoanlimit(personalInfoDbObject.getLoanlimit());

			personalInfoDto.setAddress2(personalInfoDbObject.getAddress2());
			personalInfoDto.setMobile2(personalInfoDbObject.getMobile2());
			personalInfoDto.setPhone2(personalInfoDbObject.getPhone2());
			personalInfoDto.setOldid(personalInfoDbObject.getOldid());
			personalInfoDto.setAge(personalInfoDbObject.getAge());
			personalInfoDto.setOccupation(personalInfoDbObject.getOccupation());
			personalInfoDto.setSpouse(personalInfoDbObject.getSpouse());

			personalInfoDto.setBussinessexemption(personalInfoDbObject.getBussinessexemption());
			personalInfoDto.setIntroname(personalInfoDbObject.getIntroname());

			return personalInfoDto;
		} else {

			return null;

		}

	}
}
