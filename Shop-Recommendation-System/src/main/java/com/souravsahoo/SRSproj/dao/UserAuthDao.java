package com.souravsahoo.SRSproj.dao;

import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.entity.OwnerList;

public interface UserAuthDao {

	public OwnerList findByOwnerName(String ownerName);

	public void saveOwner(OwnerList owner);

}
