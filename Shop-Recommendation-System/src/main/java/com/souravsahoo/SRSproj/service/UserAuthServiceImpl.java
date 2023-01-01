package com.souravsahoo.SRSproj.service;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.Crm_package.CrmAdmin;
import com.souravsahoo.SRSproj.Crm_package.CrmCustomer;
import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.dao.UserAuthDao;
import com.souravsahoo.SRSproj.entity.AdminList;
import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.Role;

@Service
public class UserAuthServiceImpl implements UserAuthService{

	@Autowired
	private UserAuthDao userAuthDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		OwnerList owner = userAuthDao.findByOwnerName(username);
		if(owner == null) {
			
			CustomerList customer = userAuthDao.findByCustomerName(username);
			if(customer == null) {
				
				AdminList admin = userAuthDao.findByAdminName(username);
				if(admin == null) {
					throw new UsernameNotFoundException("Invalid username or password.");
				}else {
					return new org.springframework.security.core.userdetails.User(admin.getaUsername(), admin.getaPwd(),
							mapRolesToAuthorities(admin.getRoles()));
				}
				
			}else {
				return new org.springframework.security.core.userdetails.User(customer.getcUsername(), customer.getcPwd(),
						mapRolesToAuthorities(customer.getRoles()));
			}
			
		}else {
			return new org.springframework.security.core.userdetails.User(owner.getsUsername(), owner.getsPwd(),
					mapRolesToAuthorities(owner.getRoles()));
		}
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public OwnerList findByOwnerName(String ownerName) {
		// TODO Auto-generated method stub
		return userAuthDao.findByOwnerName(ownerName);
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
		customer.setName(crmCustomer.getCutomerName());
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
		admin.setName(crmAdmin.getAdminName());
		admin.setAge(crmAdmin.getAge());
		admin.setPhoneNo(crmAdmin.getPhoneNo());
		admin.setAdminAddress(crmAdmin.getAdminAddress());
		admin.setaUsername(crmAdmin.getaUsername());
		admin.setaPwd(crmAdmin.getaPwd());
		
		userAuthDao.saveAdmin(admin);
	}
	
}
