package com.souravsahoo.SRSproj.dao;

import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;

public interface OwnerUserInfoDAO {

	void saveOwnerDetails(OwnerList ownerList);

	void saveUserDetails(CustomerList customerList);

}
