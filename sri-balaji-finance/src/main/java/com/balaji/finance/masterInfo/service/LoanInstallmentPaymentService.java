package com.balaji.finance.masterInfo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.finance.masterInfo.entity.BusinessMember;
import com.balaji.finance.masterInfo.repo.BusinessMemberRepository;
import com.balaji.finance.pojo.InstallmentDetails;
import com.balaji.finance.pojo.LoanInformation;
import com.balaji.finance.transaction.entity.CashBook;
import com.balaji.finance.transaction.entity.CashBookRepo;

@Service
public class LoanInstallmentPaymentService {

	
	@Autowired
	private BusinessMemberRepository businessMemberRepository;
	
	@Autowired
	private CashBookRepo cashBookRepo;
	

	public LoanInformation loadMFLoanPaidInfo(String id) {

	    Optional<BusinessMember> opt = businessMemberRepository.findById(id);
	    if (opt.isEmpty()) {
	        return null;
	    }

	    BusinessMember bm = opt.get();

	    LoanInformation info = new LoanInformation();
	    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    // Basic details
	    info.setAccountNo(bm.getBusinessId() + "-" +
	                      bm.getCustomerId().getFirstname() + "-" +
	                      bm.getCustomerId().getId());

	    info.setPartnerName(bm.getPartnerId().getFirstname() + "-" +
	                        bm.getPartnerId().getId());

	    info.setGuarantorName(bm.getGuarantor1().getFirstname() + "-" +
	                          bm.getGuarantor1().getId());

	    info.setPeriodFrom(bm.getStartDate().format(fmt));
	    info.setPeriodTo(bm.getEndDate().format(fmt));

	    // Loan calculations
	    double totalLoan = bm.getAmount() + bm.getInterest();
	    double installmentAmount = totalLoan / bm.getInstallment();

	    info.setLoanAmount(bm.getAmount());
	    info.setInstallmentAmount(installmentAmount);
	    info.setDate(LocalDateTime.now().format(fmt));

	    List<CashBook> paidList = cashBookRepo.findByAccountNo(bm.getId());
	    long paidInstallments = 0;
	    double totalAmountPaid = 0;

	    LocalDateTime lastPaidDate = bm.getStartDate();

	    for (CashBook cb : paidList) {
	        totalAmountPaid += cb.getCredit();

	        if ("MF LOAN".equalsIgnoreCase(cb.getTransType())) {
	            paidInstallments++;
	        }

	        lastPaidDate = cb.getTransDate();
	    }

	    double expectedPaid = paidInstallments * installmentAmount;
	    double balanceCarry = totalAmountPaid - expectedPaid;

	    List<InstallmentDetails> pending = new ArrayList<>();

	    Double totalInstallments = bm.getInstallment();
	    LocalDateTime dueDate = lastPaidDate;

	    for (long i = paidInstallments + 1; i <= totalInstallments; i++) {

	        InstallmentDetails inst = new InstallmentDetails();
	        inst.setInstallmentNumber(i);

	        dueDate = dueDate.plusMonths(1);
	        inst.setDueDate(dueDate.format(fmt));

	        double calcInstall = installmentAmount;

	        // Case: Extra paid → reduce next installment
	        if (balanceCarry > 0) {
	            double reduced = calcInstall - balanceCarry;

	            if (reduced < 0) {
	                inst.setInstallmentAmount(0);
	                balanceCarry = Math.abs(reduced); // carry forward remaining extra
	            } else {
	                inst.setInstallmentAmount(reduced);
	                balanceCarry = 0;
	            }

	        } else if (balanceCarry < 0) {
	            // Case: Deficit → next installment higher
	            inst.setInstallmentAmount(calcInstall + Math.abs(balanceCarry));
	            balanceCarry = 0;
	        } else {
	            // Normal installment
	            inst.setInstallmentAmount(calcInstall);
	        }

	        inst.setLateFee(0);
	        inst.setPaid(0);
	        inst.setTotal(installmentAmount);
	        inst.setLateFeeDate(null);

	        pending.add(inst);
	    }

	    info.setInstallmentDetailsList(pending);
	  

	    return info;
	}
	
	
	


}
