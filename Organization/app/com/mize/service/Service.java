package com.mize.service;

import java.util.List;

import com.mize.dto.Organization;

public interface Service {
	
	public  void removeOrganization(Organization org);

	public  List<Organization> getAllOrganizations();

	public Organization getOrganizationById(Organization org);

	public  Organization addOrganization(Organization org);
	
	public  Organization updateOrganization(Organization org);
	
	public List<Organization> getOrgByCode(Organization org);


}
