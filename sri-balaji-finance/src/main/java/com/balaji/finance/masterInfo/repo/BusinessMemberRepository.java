package com.balaji.finance.masterInfo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.balaji.finance.masterInfo.entity.BusinessMember;

public interface BusinessMemberRepository extends JpaRepository<BusinessMember, String> {
	
	@Query("SELECT "
		  +"  u "
		  +" FROM BusinessMember u "
		  +" WHERE  "
		  + "      u.id Like :loanType "
		  + " and (u.id like :keyword or u.customerId.firstname like :keyword or u.customerId.lastname like :keyword)")
	public List<BusinessMember> businessMemberAutoComplete(@Param("LoanType") String loanType,
			@Param("keyWord") String keyWord);

}

