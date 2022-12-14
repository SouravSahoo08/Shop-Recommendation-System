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
	public List<ShopItem> getItems(String ownerId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<ShopItem> getItemQuery = currentSession.createQuery("from ShopItem where lower(ownerId) = :oId" , ShopItem.class);
		getItemQuery.setParameter("oId", ownerId);
		List<ShopItem> items = getItemQuery.getResultList();
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
	public ShopItem getItemDetail(int itemId, String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		// List<ShopItem> item = currentSession.createQuery("from ShopItem s where
		// s.itemId = " + itemId, ShopItem.class).getResultList();
		// return item.get(0);

		ShopItem item = currentSession.get(ShopItem.class, itemId);
		return item;
	}

	@Override
	public void deleteItem(int itemId, String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<?> deleteQuery = currentSession.createQuery("delete from ShopItem where itemId = :itemId and lower(ownerId) = :oId");
		deleteQuery.setParameter("itemId", itemId);
		deleteQuery.setParameter("oId", ownerId);
		deleteQuery.executeUpdate();
		//currentSession.delete(currentSession.get(ShopItem.class, itemId));
	}
	
	/**
	 * Search a particular item in list
	 * @return searched items
	 */
	@Override
	public List<ShopItem> searchItem(String searchItemName, String ownerId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<ShopItem> searchItemQuery = null;

		if (searchItemName != null && searchItemName.trim().length() > 0) {
			searchItemQuery = currentSession.createQuery(
					"from ShopItem where lower(ownerId) = :oId and lower(itemName) like :sName or lower(itemType) like :sName",
					ShopItem.class);
			searchItemQuery.setParameter("sName", "%" + searchItemName.toLowerCase() + "%");
		} else if(searchItemName == null) {
			searchItemQuery = currentSession.createQuery("from ShopItem where lower(ownerId) = :oId", ShopItem.class);
		}
		searchItemQuery.setParameter("oId", ownerId);

		List<ShopItem> searchedItemList = searchItemQuery.getResultList();

		return searchedItemList;
	}

}
