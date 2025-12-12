package com.balaji.finance.masterInfo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.balaji.finance.masterInfo.entity.BusinessMember;

public interface BusinessMemberRepository extends JpaRepository<BusinessMember, String> {
	
	@Query("SELECT u FROM BusinessMember u " +
		       "WHERE LOWER(u.id) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
		       "OR LOWER(u.customerId.firstname) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
		       "OR LOWER(u.customerId.lastname) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<BusinessMember> businessMemberAutoComplete(@Param("keyword") String keyword);


	
	
	@Query("SELECT u FROM BusinessMember u WHERE u.id like :keyword")
	List<BusinessMember> businessMemberList(@Param("keyword") String keyword);

}

