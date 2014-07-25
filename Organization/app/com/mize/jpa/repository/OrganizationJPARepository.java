package com.mize.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mize.dto.Organization;

@Repository
public interface OrganizationJPARepository extends JpaRepository<Organization, Integer>{
	
	//public final static String FIND_BY_CODE_QUERY = "SELECT o FROM organization o WHERE o.code = ?1";
	 
	 
	 //@Query(FIND_BY_CODE_QUERY)
	    public List<Organization> findOrgByCode(String code);

}
