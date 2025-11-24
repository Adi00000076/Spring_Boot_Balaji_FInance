package com.balaji.finance.masterInfo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balaji.finance.masterInfo.entity.BusinessMember;

public interface BusinessMemberRepository extends JpaRepository<BusinessMember, String>{

}
