package com.souravsahoo.SRSproj.service;

import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;

public interface OwnerUserInfo_Service {

	void saveOwnerDetails(OwnerList ownerList);

	void saveUserDetails(CustomerList customerList);

}
