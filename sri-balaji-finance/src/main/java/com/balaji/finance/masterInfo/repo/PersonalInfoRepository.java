package com.balaji.finance.masterInfo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.balaji.finance.masterInfo.entity.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, String> {

	@Query("SELECT u FROM PersonalInfo u WHERE u.disable =:status")
	public List<PersonalInfo> findAllActiveRecords(@Param("status") boolean status);

	@Query("SELECT u FROM PersonalInfo u WHERE u.disable =:status and (u.id like :keyword or u.firstname like :keyword or u.lastname like :keyword) and category IN (:categoryList)")
	public List<PersonalInfo> personalInfoAutoComplete(@Param("status") boolean status,
			@Param("keyword") String keyWord, @Param("categoryList") List<String> categoryList);
}
