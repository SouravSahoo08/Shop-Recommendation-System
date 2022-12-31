package com.souravsahoo.SRSproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.dao.UserAuthDao;
import com.souravsahoo.SRSproj.entity.OwnerList;

public class UserAuthServiceImpl implements UserAuthService{

	@Autowired
	private UserAuthDao userAuthDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OwnerList findByOwnerName(String ownerName) {
		// TODO Auto-generated method stub
		return userAuthDao.findByOwnerName(ownerName);
	}

	@Override
	public void saveOwner(CrmOwner crmOwner) {
		// TODO Auto-generated method stub
		OwnerList owner = new OwnerList();
		owner.setOwnerName(crmOwner.getOwnerName());
		owner.setLicenseNo(crmOwner.getLicenseNo());
		owner.setAge(crmOwner.getAge());
		owner.setPhoneNo(crmOwner.getPhoneNo());
		owner.setShopType(crmOwner.getShopType());
		owner.setShopAddress(crmOwner.getShopAddress());
		owner.setsUsername(crmOwner.getsUsername());
		owner.setsPwd(crmOwner.getsPwd());
		
		userAuthDao.saveOwner(owner);
	}

}
