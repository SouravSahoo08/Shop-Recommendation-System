package com.souravsahoo.SRSproj.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.entity.OwnerList;

public interface UserAuthService extends UserDetailsService{
	
	OwnerList findByOwnerName(String ownerName);
	void saveOwner(CrmOwner crmOwner);
	
}
