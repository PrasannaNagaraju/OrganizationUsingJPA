package com.mize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mize.dto.Organization;
import com.mize.jpa.repository.OrganizationJPARepository;
@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
	
	@Autowired
	OrganizationJPARepository organizationJPARepository;

	public List<Organization> getAllOrganizations() {
		
		return organizationJPARepository.findAll();
	}

	@Override
	public Organization getOrganizationById(Organization org) {
		
		return organizationJPARepository.findOne(org.getId());
	}

	@Override
	public Organization addOrganization(Organization org) {
		return organizationJPARepository.save(org);
		
	}

	@Override
	public void removeOrganization(Organization org) {
		
		organizationJPARepository.delete(org);
	}

	@Override
	public Organization updateOrganization(Organization org) {
		
		return organizationJPARepository.save(org);
	}

	@Override
	public List<Organization> getOrgByCode(Organization org) {
		
		
		return	organizationJPARepository.findOrgByCode(org.getCode());
		}
	

}
