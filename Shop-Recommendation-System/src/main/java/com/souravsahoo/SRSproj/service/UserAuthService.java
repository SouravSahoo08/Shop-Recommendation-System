package com.souravsahoo.SRSproj.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.souravsahoo.SRSproj.Crm_package.CrmAdmin;
import com.souravsahoo.SRSproj.Crm_package.CrmCustomer;
import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.entity.AdminList;
import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;

public interface UserAuthService extends UserDetailsService{
	
	OwnerList findByOwnerName(String ownerName);
	void saveOwner(CrmOwner crmOwner);
	void saveCustomer(CrmCustomer crmCustomer);
	void saveAdmin(CrmAdmin crmAdmin);
	CustomerList findByCustomerName(String customerName);
	AdminList findByAdminName(String adminName);
	
}
