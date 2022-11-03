package com.souravsahoo.SRSproj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.ShopItem;

@Repository
public class ShopDAOImpl implements ShopDAO{

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<ShopItem> getItems() {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		List<ShopItem> items = currentSession.createQuery("from ShopItem", ShopItem.class).getResultList(); 
		return items;
	}

	
	
}
