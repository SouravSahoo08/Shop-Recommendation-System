package com.souravsahoo.SRSproj.dao;

import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.UserList;

public interface OwnerUserInfoDAO {

	void saveOwnerDetails(OwnerList ownerList);

	void saveUserDetails(UserList userList);

}
