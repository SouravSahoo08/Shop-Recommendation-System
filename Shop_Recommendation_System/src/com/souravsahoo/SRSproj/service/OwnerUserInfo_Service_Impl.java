package com.souravsahoo.SRSproj.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.dao.OwnerUserInfoDAO;
import com.souravsahoo.SRSproj.entity.OwnerList;

@Service
public class OwnerUserInfo_Service_Impl implements OwnerUserInfo_Service {

	@Autowired
	private OwnerUserInfoDAO ownerUserInfoDao; 
	
	@Override
	@Transactional
	public void saveOwnerDetails(OwnerList ownerList) {
		ownerUserInfoDao.saveOwnerDetails(ownerList);		
	}

}
