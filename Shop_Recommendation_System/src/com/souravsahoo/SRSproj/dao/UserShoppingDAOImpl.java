package com.souravsahoo.SRSproj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.ShopItem;

@Repository
public class UserShoppingDAOImpl implements UserShoppingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Returns the list of all items in the db
	 * 
	 * @return list of items
	 */
	@Override
	public List<ShopItem> getItems() {

		Session currentSession = sessionFactory.getCurrentSession();
		List<ShopItem> items = currentSession.createQuery("from ShopItem", ShopItem.class).getResultList();
		return items;
	}
}
