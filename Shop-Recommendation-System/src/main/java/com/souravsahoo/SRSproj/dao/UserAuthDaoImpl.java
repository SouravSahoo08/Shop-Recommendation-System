package com.souravsahoo.SRSproj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.AdminList;
import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;

@Repository
public class UserAuthDaoImpl implements UserAuthDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public OwnerList findByOwnerName(String ownerName) {
		Session currSession = sessionFactory.getCurrentSession();
		Query<OwnerList> query = currSession.createQuery("from OwnerList where ownerName = :ownerName",
				OwnerList.class);
		query.setParameter("ownerName", ownerName);

		OwnerList owner = null;

		try {
			owner = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			owner = null;
		}

		return owner;
	}

	@Override
	public void saveOwner(OwnerList owner) {
		// TODO Auto-generated method stub
		Session currSession = sessionFactory.getCurrentSession();
		currSession.saveOrUpdate(owner);
	}

	@Override
	public CustomerList findByCustomerName(String customerName) {
		Session currSession = sessionFactory.getCurrentSession();
		Query<CustomerList> query = currSession.createQuery("from CustomerList where ownerName = :customerName",
				CustomerList.class);
		query.setParameter("customerName", customerName);

		CustomerList customer = null;

		try {
			customer = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			customer = null;
		}

		return customer;
	}


	@Override
	public void saveCustomer(CustomerList customer) {
		Session currSession = sessionFactory.getCurrentSession();
		currSession.saveOrUpdate(customer);
	}
	
	@Override
	public AdminList findByAdminName(String adminName) {
		Session currSession = sessionFactory.getCurrentSession();
		Query<AdminList> query = currSession.createQuery("from AdminList where ownerName = :adminName",
				AdminList.class);
		query.setParameter("customerName", adminName);

		AdminList admin = null;

		try {
			admin = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			admin = null;
		}

		return admin;
	}


	@Override
	public void saveAdmin(AdminList admin) {
		Session currSession = sessionFactory.getCurrentSession();
		currSession.saveOrUpdate(admin);
	}

}
