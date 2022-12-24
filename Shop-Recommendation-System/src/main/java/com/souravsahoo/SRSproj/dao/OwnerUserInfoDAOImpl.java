package com.souravsahoo.SRSproj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.UserList;

@Repository
public class OwnerUserInfoDAOImpl implements OwnerUserInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOwnerDetails(OwnerList ownerList) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(ownerList);
	}

	@Override
	public void saveUserDetails(UserList userList) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(userList);
	}
	
}
