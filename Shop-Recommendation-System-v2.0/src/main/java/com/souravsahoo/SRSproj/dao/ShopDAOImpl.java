package com.souravsahoo.SRSproj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.OwnerCartItem;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;

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
		Query<ShopItem> getItemQuery = currentSession.createQuery("from ShopItem where lower(ownerId) = :oId",
				ShopItem.class);
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

		int stockCount = getStockCount(currentSession, itemId, ownerId);
		System.out.println("LOG: Stock available >> " + stockCount);

		// if stocks available is more than one then reduce the stock by 1
		if (stockCount > 1) {
			Query<?> updateStockQuery = currentSession.createQuery(
					"update ShopItem set stock = :newStock " + " where itemId = :itemId and lower(ownerId) = :oId");
			updateStockQuery.setParameter("newStock", stockCount - 1);
			updateStockQuery.setParameter("itemId", itemId);
			updateStockQuery.setParameter("oId", ownerId);
			updateStockQuery.executeUpdate();
		}
		// else remove the entire item
		else {
			Query<?> deleteQuery = currentSession
					.createQuery("delete from ShopItem where itemId = :itemId and lower(ownerId) = :oId");
			deleteQuery.setParameter("itemId", itemId);
			deleteQuery.setParameter("oId", ownerId);
			deleteQuery.executeUpdate();

		}
	}

	private int getStockCount(Session currentSession, int itemId, String ownerId) {

		Query<ShopItem> itemQuery = currentSession
				.createQuery("from ShopItem where itemId = :itemId and lower(ownerId) = :oId", ShopItem.class);
		itemQuery.setParameter("itemId", itemId);
		itemQuery.setParameter("oId", ownerId);

		List<ShopItem> items = itemQuery.getResultList();
		return items.get(0).getStock();
	}

	/**
	 * Search a particular item in list
	 * 
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
		} else if (searchItemName == null) {
			searchItemQuery = currentSession.createQuery("from ShopItem where lower(ownerId) = :oId", ShopItem.class);
		}
		searchItemQuery.setParameter("oId", ownerId);

		List<ShopItem> searchedItemList = searchItemQuery.getResultList();

		return searchedItemList;
	}

	@Override
	public void addItemToCart(ShopItem itemDetail, String ownerId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		boolean isItemPresent = checkIfItemPresent(currentSession, ownerId, itemDetail.getItemId());

		if (isItemPresent) {
			int quantity = updateQuantity(currentSession, ownerId, itemDetail.getItemId(), 1);
			Query<?> updateItemQuery = currentSession.createQuery(
					"update OwnerCartItem set quantity = :oQuant where lower(ownerId) = :oId and itemId = :oItemId");

			updateItemQuery.setParameter("oQuant", quantity);
			updateItemQuery.setParameter("oId", ownerId.toLowerCase());
			updateItemQuery.setParameter("oItemId", itemDetail.getItemId());
			updateItemQuery.executeUpdate();

		} else {
			OwnerCartItem cartItem = new OwnerCartItem();
			cartItem.setOwnerId(ownerId);
			cartItem.setItemId(itemDetail.getItemId());
			cartItem.setItemType(itemDetail.getItemType());
			cartItem.setItemName(itemDetail.getItemName());
			cartItem.setItemPrice(itemDetail.getPrice());
			cartItem.setQuantity(1);
			cartItem.setExpDate(itemDetail.getExpDate());

			System.out.println("ShoppingDao: addItemToCart ====> " + cartItem);
			currentSession.save(cartItem);
		}

	}
	
	private boolean checkIfItemPresent(Session currentSession, String ownerId, int itemId) {

		Query<OwnerCartItem> checkItemQuery = currentSession.createQuery(
				"from OwnerCartItem where " + "lower(ownerId) = :oId " + "and itemId = :oItemId order by quantity",
				OwnerCartItem.class);
		checkItemQuery.setParameter("oId", ownerId.toLowerCase());
		checkItemQuery.setParameter("oItemId", itemId);
		List<OwnerCartItem> foundItemInCart = checkItemQuery.getResultList();
		System.out.println("\n\ncart list ===> " + foundItemInCart);
		if (foundItemInCart.isEmpty()) {
			// if same itemId item is not present
			return false;
		}

		return true;
	}

	private int updateQuantity(Session currentSession, String ownerId, int itemId, int changeBy) {

		int quantity;

		String query = "from OwnerCartItem where lower(ownerId) = :oId and itemId = :oItemId";
		Query<OwnerCartItem> quantityQuery = currentSession.createQuery(query, OwnerCartItem.class);
		quantityQuery.setParameter("oId", ownerId.toLowerCase());
		quantityQuery.setParameter("oItemId", itemId);

		List<OwnerCartItem> itemWithMaxQuantity = quantityQuery.getResultList();
		System.out.println("\n\nitemWithMaxQuantity ===> " + itemWithMaxQuantity);

		OwnerCartItem item = itemWithMaxQuantity.get(0);
		quantity = item.getQuantity() + changeBy;
		System.out.println("Quantity : " + quantity);

		return quantity;
	}

	@Override
	public List<OwnerCartItem> showCart(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<OwnerCartItem> createQuery = currentSession.createQuery("from OwnerCartItem where lower(ownerId) = :oId",
				OwnerCartItem.class);
		createQuery.setParameter("oId", ownerId);
		List<OwnerCartItem> items = createQuery.getResultList();

		return items;
	}
}
