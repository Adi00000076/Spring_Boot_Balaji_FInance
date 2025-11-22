package com.balaji.finance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.balaji.finance.entity.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, String> {

	@Query("SELECT u FROM PersonalInfo u WHERE u.disable =:status")
	public List<PersonalInfo> findAllActiveRecords(@Param("status") boolean status);

}
