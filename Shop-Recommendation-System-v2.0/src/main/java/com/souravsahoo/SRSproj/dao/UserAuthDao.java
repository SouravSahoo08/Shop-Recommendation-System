package com.souravsahoo.SRSproj.dao;

import com.souravsahoo.SRSproj.entity.AdminList;
import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;

public interface UserAuthDao {

	public OwnerList findByOwnerName(String ownerName);

	public void saveOwner(OwnerList owner);

	public CustomerList findByCustomerName(String customerName);

	public AdminList findByAdminName(String adminName);

	public void saveCustomer(CustomerList customer);

	public void saveAdmin(AdminList admin);

}
