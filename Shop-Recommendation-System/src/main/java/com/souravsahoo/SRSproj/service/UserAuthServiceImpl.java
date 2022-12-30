package com.souravsahoo.SRSproj.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.entity.OwnerList;

public class UserAuthServiceImpl implements UserAuthService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OwnerList findByOwnerName(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOwner(CrmOwner crmOwner) {
		// TODO Auto-generated method stub
		
	}

}
