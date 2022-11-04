package com.souravsahoo.SRSproj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.ShopItem;

@Repository
public class ShopDAOImpl implements ShopDAO {

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

	/**
	 * if new primary key, then save(insert) else if previous id, update
	 * 
	 * @param @ShopItem object
	 */
	@Override
	public void saveItem(ShopItem shopItem) {
		Session currentSession = sessionFactory.getCurrentSession();

		// if new primary key, then save(insert) else if previous id, update
		currentSession.saveOrUpdate(shopItem);
	}

	/**
	 * returns the details of a particular item
	 * 
	 * @return @ShopItem object
	 */
	@Override
	public ShopItem getItemDetail(int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();
		// List<ShopItem> item = currentSession.createQuery("from ShopItem s where
		// s.itemId = " + itemId, ShopItem.class).getResultList();
		// return item.get(0);

		ShopItem item = currentSession.get(ShopItem.class, itemId);
		return item;
	}

	@Override
	public void deleteItem(int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(currentSession.get(ShopItem.class, itemId));
	}

	@Override
	public List<ShopItem> searchItem(String searchItemName) {
		System.out.println("in search");
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ShopItem> searchItemQuery = null;

		if (searchItemName != null && searchItemName.trim().length() > 0) {
			searchItemQuery = currentSession.createQuery(
					"from ShopItem where " + "lower(itemName) like :sName " + "or lower(itemType) like :sName",
					ShopItem.class);
			searchItemQuery.setParameter("sName", "%" + searchItemName.toLowerCase() + "%");
		}else {
			searchItemQuery = currentSession.createQuery("from ShopItem", ShopItem.class);
		}
		
		List<ShopItem> resultList = searchItemQuery.getResultList();
		System.out.println(resultList);
		return resultList;
	}

}
