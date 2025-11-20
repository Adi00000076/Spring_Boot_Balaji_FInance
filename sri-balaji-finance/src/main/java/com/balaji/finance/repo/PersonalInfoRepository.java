package com.balaji.finance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balaji.finance.entity.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, String> {

}
