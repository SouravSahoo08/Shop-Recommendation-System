package com.souravsahoo.SRSproj.service;

import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.UserList;

public interface OwnerUserInfo_Service {

	void saveOwnerDetails(OwnerList ownerList);

	void saveUserDetails(UserList userList);

}
