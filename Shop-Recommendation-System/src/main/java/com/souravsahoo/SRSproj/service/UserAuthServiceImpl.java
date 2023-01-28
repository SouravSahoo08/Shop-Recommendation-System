package com.souravsahoo.SRSproj.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.Crm_package.CrmAdmin;
import com.souravsahoo.SRSproj.Crm_package.CrmCustomer;
import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.dao.UserAuthDao;
import com.souravsahoo.SRSproj.entity.AdminList;
import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;

@Service
public class UserAuthServiceImpl implements UserAuthService{

	@Autowired
	private UserAuthDao userAuthDao;
	
	@Override
	@Transactional
	public OwnerList findByOwnerName(String ownerName) {
		// TODO Auto-generated method stub
		return userAuthDao.findByOwnerName(ownerName);
	}

	@Override
	@Transactional
	public CustomerList findByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		return userAuthDao.findByCustomerName(customerName);
	}
	
	@Override
	@Transactional
	public AdminList findByAdminName(String adminName) {
		// TODO Auto-generated method stub
		return userAuthDao.findByAdminName(adminName);
	}
	
	@Override
	@Transactional
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

	@Override
	@Transactional
	public void saveCustomer(CrmCustomer crmCustomer) {
		// TODO Auto-generated method stub
		CustomerList customer = new CustomerList();
		customer.setCustomerName(crmCustomer.getCustomerName());
		customer.setAge(crmCustomer.getAge());
		customer.setPhoneNo(crmCustomer.getPhoneNo());
		customer.setUserAddress(crmCustomer.getUserAddress());
		customer.setcUsername(crmCustomer.getcUsername());
		customer.setcPwd(crmCustomer.getcPwd());
		
		userAuthDao.saveCustomer(customer);
	}
	
	@Override
	@Transactional
	public void saveAdmin(CrmAdmin crmAdmin) {
		// TODO Auto-generated method stub
		AdminList admin = new AdminList();
		admin.setAdminName(crmAdmin.getAdminName());
		admin.setAge(crmAdmin.getAge());
		admin.setPhoneNo(crmAdmin.getPhoneNo());
		admin.setAdminAddress(crmAdmin.getAdminAddress());
		admin.setaUsername(crmAdmin.getaUsername());
		admin.setaPwd(crmAdmin.getaPwd());
		
		userAuthDao.saveAdmin(admin);
	}
	
}
