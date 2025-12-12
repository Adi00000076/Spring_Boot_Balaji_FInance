package com.balaji.finance.masterInfo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.balaji.finance.dto.BusinessMemberDto;
import com.balaji.finance.masterInfo.entity.BusinessMember;
import com.balaji.finance.masterInfo.entity.PersonalInfo;
import com.balaji.finance.masterInfo.repo.BusinessMemberRepository;
import com.balaji.finance.masterInfo.repo.PersonalInfoRepository;
import com.balaji.finance.pojo.BusinessMemberAutoCompletePojo;
import com.balaji.finance.util.BusinessMemersSequenceService;

@Service
public class BusinessMemberService {

	@Autowired
	private BusinessMemberRepository businessMemberRepository;

	@Autowired
	private BusinessMemersSequenceService businessMemersSequenceService;

	@Autowired
	private PersonalInfoRepository personalInfoRepository;

	@Value("${dailyfinance.duration}")
	private Double dailyfinance_duration;

	@Value("${dailyfinance.basicIntrest}")
	private Double dailyfinance_basicIntrest;

	public String generateId(String type) {

		String prefix;
		long seq = 0;
		switch (type) {
		case "DAILY_FINANCE":
			prefix = "DF";
			seq = businessMemersSequenceService.getNextBusinessMemberDailyFinanceSequenceSeqId();
			break;

		case "MONTHLY_FINANCE":
			prefix = "MF";
			seq = businessMemersSequenceService.getNextBusinessMemberMonthlyFinanceSequenceSeqId();
			break;

		default:
			throw new IllegalArgumentException("Unknown type: " + type);
		}

		int year = LocalDate.now().getYear();

		return prefix + year + "-" + seq;
	}

	// create
	public String saveBusinessMember(BusinessMemberDto businessMemberDto, String type) {

		BusinessMember businessMember = new BusinessMember();
		businessMember.setId(generateId(type));

		if (businessMemberDto.getCustomerId() != null && !businessMemberDto.getCustomerId().isBlank()) {
			Optional<PersonalInfo> customerOptional = personalInfoRepository
					.findById(businessMemberDto.getCustomerId());
			if (customerOptional.isPresent()) {
				businessMember.setCustomerId(customerOptional.get());
			}
		}

		if (businessMemberDto.getGuarantor1() != null && !businessMemberDto.getGuarantor1().isBlank()) {
			Optional<PersonalInfo> gureantor1Optional = personalInfoRepository
					.findById(businessMemberDto.getGuarantor1());
			if (gureantor1Optional.isPresent()) {
				businessMember.setGuarantor1(gureantor1Optional.get());
			}
		}
		if (businessMemberDto.getGuarantor2() != null && !businessMemberDto.getGuarantor2().isBlank()) {
			Optional<PersonalInfo> gureantor2Optional = personalInfoRepository
					.findById(businessMemberDto.getGuarantor2());
			if (gureantor2Optional.isPresent()) {
				businessMember.setGuarantor2(gureantor2Optional.get());
			}
		}
		if (businessMemberDto.getGuarantor3() != null && !businessMemberDto.getGuarantor3().isBlank()) {
			Optional<PersonalInfo> gureantor3Optional = personalInfoRepository
					.findById(businessMemberDto.getGuarantor3());
			if (gureantor3Optional.isPresent()) {
				businessMember.setGuarantor3(gureantor3Optional.get());
			}
		}
		if (businessMemberDto.getPartnerId() != null && !businessMemberDto.getPartnerId().isBlank()) {
			Optional<PersonalInfo> partnerOptional = personalInfoRepository.findById(businessMemberDto.getPartnerId());
			if (partnerOptional.isPresent()) {
				businessMember.setPartnerId(partnerOptional.get());
			}
		}

		businessMember.setStartDate(businessMemberDto.getStartDate());
		businessMember.setEndDate(businessMemberDto.getEndDate());

		businessMember.setAmount(businessMemberDto.getAmount());

		switch (type) {
		case "DAILY_FINANCE":

			businessMember.setDuration(dailyfinance_duration);
			businessMember.setInterest(dailyfinance_basicIntrest);
			break;

		case "MONTHLY_FINANCE":

			break;

		default:

			break;
		}

		businessMember.setInstallment(businessMemberDto.getInstallment());

		businessMember.setStatus(businessMemberDto.isStatus());
		businessMember.setPaidInstallments(businessMemberDto.getPaidInstallments());
		businessMember.setPartPrincipal(businessMemberDto.getPartPrincipal());
		businessMember.setUnpaidLateFee(businessMemberDto.getUnpaidLateFee());
		businessMember.setChequeReminder(businessMemberDto.isChequeReminder());
		businessMember.setBusinessId(businessMemberDto.getBusinessId());
		businessMember.setSecurity(businessMemberDto.getSecurity());

		businessMemberRepository.save(businessMember);

		return "Sucessfully Saved ";
	}

	// update
	public String updateBusinessMember(BusinessMemberDto businessMemberDto) {

		Optional<BusinessMember> businessMemberInDb = businessMemberRepository.findById(businessMemberDto.getId());

		if (businessMemberInDb.isPresent()) {

			BusinessMember businessMember = businessMemberInDb.get();

			Optional<PersonalInfo> customerOptional = personalInfoRepository
					.findById(businessMemberDto.getCustomerId());
			if (customerOptional.isPresent()) {
				businessMember.setCustomerId(customerOptional.get());
			}

			Optional<PersonalInfo> gureantor1Optional = personalInfoRepository
					.findById(businessMemberDto.getGuarantor1());
			if (gureantor1Optional.isPresent()) {
				businessMember.setGuarantor1(gureantor1Optional.get());
			}

			Optional<PersonalInfo> gureantor2Optional = personalInfoRepository
					.findById(businessMemberDto.getGuarantor2());
			if (gureantor2Optional.isPresent()) {
				businessMember.setGuarantor2(gureantor2Optional.get());
			}

			Optional<PersonalInfo> gureantor3Optional = personalInfoRepository
					.findById(businessMemberDto.getGuarantor3());
			if (gureantor3Optional.isPresent()) {
				businessMember.setGuarantor3(gureantor3Optional.get());
			}

			Optional<PersonalInfo> partnerOptional = personalInfoRepository.findById(businessMemberDto.getPartnerId());
			if (partnerOptional.isPresent()) {
				businessMember.setPartnerId(partnerOptional.get());
			}

			businessMember.setStartDate(businessMemberDto.getStartDate());
			businessMember.setEndDate(businessMemberDto.getEndDate());

			businessMember.setAmount(businessMemberDto.getAmount());
			businessMember.setDuration(businessMemberDto.getDuration());

			businessMember.setInterest(businessMemberDto.getInterest());
			businessMember.setInstallment(businessMemberDto.getInstallment());

			businessMember.setStatus(businessMemberDto.isStatus());
			businessMember.setPaidInstallments(businessMemberDto.getPaidInstallments());
			businessMember.setPartPrincipal(businessMemberDto.getPartPrincipal());
			businessMember.setUnpaidLateFee(businessMemberDto.getUnpaidLateFee());
			businessMember.setChequeReminder(businessMemberDto.isChequeReminder());
			businessMember.setBusinessId(businessMemberDto.getBusinessId());
			businessMember.setSecurity(businessMemberDto.getSecurity());

			businessMemberRepository.save(businessMember);

			return "Sucessfully Updated ";

		} else {

			return "Record Not Found ";

		}

	}

	// delete
	public String deleteBusinessMember(String id) {

		Optional<BusinessMember> businessMemberInDb = businessMemberRepository.findById(id);

		if (businessMemberInDb.isPresent()) {

			BusinessMember businessMember = businessMemberInDb.get();

			businessMemberRepository.delete(businessMember);

			return "Sucessfully Deleted " + businessMember.getId();

		} else {

			return "Record Not Found " + id;

		}

	}

	// findAll
	public List<BusinessMemberDto> findAll(String type) {

		String prefix;
		switch (type) {
		case "DAILY_FINANCE":
			prefix = "DF";
			break;

		case "MONTHLY_FINANCE":
			prefix = "MF";
			break;

		default:
			throw new IllegalArgumentException("Unknown type: " + type);
		}

		
		
		List<BusinessMember> allBusinessMemberList = businessMemberRepository.businessMemberList("%"+prefix+"%");

		List<BusinessMemberDto> toBeReturnedDtoList = new ArrayList<BusinessMemberDto>();

		allBusinessMemberList.stream().forEach(p -> {

			BusinessMemberDto businessMemberDto = new BusinessMemberDto();
			businessMemberDto.setId(p.getId());
			businessMemberDto.setCustomerId(p.getCustomerId() != null ? p.getCustomerId().getId() : null);
			businessMemberDto.setGuarantor1(p.getGuarantor1() != null ? p.getGuarantor1().getId() : null);
			businessMemberDto.setGuarantor2(p.getGuarantor2() != null ? p.getGuarantor2().getId() : null);
			businessMemberDto.setPartnerId(p.getPartnerId() != null ? p.getPartnerId().getId() : null);

			businessMemberDto.setStartDate(p.getStartDate());
			businessMemberDto.setEndDate(p.getEndDate());

			businessMemberDto.setAmount(p.getAmount());
			businessMemberDto.setDuration(p.getDuration());
			businessMemberDto.setInterest(p.getInterest());
			businessMemberDto.setInstallment(p.getInstallment());
			businessMemberDto.setSecurity(p.getSecurity());
			businessMemberDto.setStatus(p.isStatus());
			businessMemberDto.setPaidInstallments(p.getPaidInstallments());
			businessMemberDto.setPartPrincipal(p.getPartPrincipal());
			businessMemberDto.setPartInterest(p.getPartInterest());
			businessMemberDto.setUnpaidLateFee(p.getUnpaidLateFee());
			businessMemberDto.setChequeReminder(p.isChequeReminder());
			businessMemberDto.setBusinessId(p.getBusinessId());

			toBeReturnedDtoList.add(businessMemberDto);

		});

		return toBeReturnedDtoList;
	}

	// findAll
	public BusinessMemberDto findById(String id) {

		Optional<BusinessMember> businessMember = businessMemberRepository.findById(id);

		if (businessMember.isPresent()) {

			BusinessMember p = businessMember.get();

			BusinessMemberDto businessMemberDto = new BusinessMemberDto();
			businessMemberDto.setId(p.getId());
			businessMemberDto.setCustomerId(p.getCustomerId() != null ? p.getCustomerId().getId() : null);
			businessMemberDto.setGuarantor1(p.getGuarantor1() != null ? p.getGuarantor1().getId() : null);
			businessMemberDto.setGuarantor2(p.getGuarantor2() != null ? p.getGuarantor2().getId() : null);
			businessMemberDto.setPartnerId(p.getPartnerId() != null ? p.getPartnerId().getId() : null);

			businessMemberDto.setStartDate(p.getStartDate());
			businessMemberDto.setEndDate(p.getEndDate());

			businessMemberDto.setAmount(p.getAmount());
			businessMemberDto.setDuration(p.getDuration());
			businessMemberDto.setInterest(p.getInterest());
			businessMemberDto.setInstallment(p.getInstallment());
			businessMemberDto.setSecurity(p.getSecurity());
			businessMemberDto.setStatus(p.isStatus());
			businessMemberDto.setPaidInstallments(p.getPaidInstallments());
			businessMemberDto.setPartPrincipal(p.getPartPrincipal());
			businessMemberDto.setPartInterest(p.getPartInterest());
			businessMemberDto.setUnpaidLateFee(p.getUnpaidLateFee());
			businessMemberDto.setChequeReminder(p.isChequeReminder());
			businessMemberDto.setBusinessId(p.getBusinessId());

			return businessMemberDto;

		} else {

			return null;

		}

	}

	public List<BusinessMemberAutoCompletePojo> businessMemberAutoComplete(String keyWord, String loanType) {

		String starWithString = null;
		switch (loanType) {
		case "DAILY_FINANCE":
			starWithString = "DF";
			break;

		case "MONTHLY_FINANCE":
			starWithString = "MF";
			break;

		default:

			break;
		}

		List<BusinessMember> loanList = businessMemberRepository.businessMemberAutoComplete(keyWord);

		List<BusinessMemberAutoCompletePojo> pojoList = new ArrayList<BusinessMemberAutoCompletePojo>();
		System.err.println(loanList);
		for (BusinessMember bm : loanList) {

			BusinessMemberAutoCompletePojo pojo = new BusinessMemberAutoCompletePojo();
			pojo.setLoanId(bm.getId());
			pojo.setCustomerId(bm.getCustomerId().getId());
			pojo.setCustomerName(bm.getCustomerId().getFirstname());

			pojoList.add(pojo);
		}

		return pojoList;
	}

}
