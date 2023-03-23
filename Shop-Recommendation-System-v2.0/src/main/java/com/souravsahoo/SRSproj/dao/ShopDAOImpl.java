package com.souravsahoo.SRSproj.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.Orders;
import com.souravsahoo.SRSproj.entity.OwnerCartItem;
import com.souravsahoo.SRSproj.entity.ShipmentDetails;
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

	@Override
	public List<OwnerCartItem> showCart(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<OwnerCartItem> createQuery = currentSession.createQuery("from OwnerCartItem where lower(ownerId) = :oId",
				OwnerCartItem.class);
		createQuery.setParameter("oId", ownerId);
		List<OwnerCartItem> items = createQuery.getResultList();

		return items;
	}

	@Override
	public void removeItemFromCart(String ownerId, int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<OwnerCartItem> getItemQuery = currentSession.createQuery(
				"from OwnerCartItem where lower(ownerId) = :oId and itemId = :oItemId", OwnerCartItem.class);
		getItemQuery.setParameter("oId", ownerId.toLowerCase());
		getItemQuery.setParameter("oItemId", itemId);

		List<OwnerCartItem> itemList = getItemQuery.getResultList();
		System.out.println("\n\nitemList ===> " + itemList);

		OwnerCartItem item = itemList.get(0);

		if (item.getQuantity() > 1)
			item.setQuantity(updateQuantity(currentSession, ownerId, itemId, -1));
		else
			currentSession.delete(item);
	}

	@Override
	public void add_to_orders(List<OwnerCartItem> cartItems, ShipmentDetails shipmentDetails, String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Date date = new Date();
		java.sql.Date currentDate = new java.sql.Date(date.getTime());

		for (OwnerCartItem item : cartItems) {
			Orders order = new Orders();
			order.setOwnerId(ownerId);
			order.setItemId(item.getItemId());
			order.setItemType(item.getItemType());
			order.setItemName(item.getItemName());
			order.setPrice(item.getItemPrice());
			order.setQuantity(item.getQuantity());
			order.setExpDate(item.getExpDate());
			order.setOrderDate(currentDate.toString());
			order.setShipmentDetail(shipmentDetails);
			System.out.println(order);

			currentSession.save(order);
		}
	}

	@Override
	public void emptyOwnerCart(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> emptyCartQuery = currentSession.createQuery("delete from OwnerCartItem where lower(ownerId) = :oId");
		emptyCartQuery.setParameter("oId", ownerId);
		emptyCartQuery.executeUpdate();
	}

	@Override
	public void updateStocks(String ownerId, List<OwnerCartItem> cartItems) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		for (OwnerCartItem item : cartItems) {
			int item_id = item.getItemId();
			int quantity_purchased = item.getQuantity();
			int available_stock_quantity = getStockCount(currentSession, item_id, ownerId);

			Query<?> updateStockQuery = currentSession.createQuery(
					"update ShopItem set stock = :newStock where itemId = :itemId and lower(ownerId) = :oId");
			// if difference is greater than or equal to 1, then update the stocks
			if (available_stock_quantity - quantity_purchased >= 1) {
				updateStockQuery.setParameter("newStock", available_stock_quantity - quantity_purchased);
			}
			// else remove the entire item
			else {
				updateStockQuery.setParameter("newStock", 0);
			}
			updateStockQuery.setParameter("itemId", item_id);
			updateStockQuery.setParameter("oId", ownerId);
			updateStockQuery.executeUpdate();

		}

	}

	/* ************** Utilities ****************** */

	private int getStockCount(Session currentSession, int itemId, String ownerId) {

		Query<ShopItem> itemQuery = currentSession
				.createQuery("from ShopItem where itemId = :itemId and lower(ownerId) = :oId", ShopItem.class);
		itemQuery.setParameter("itemId", itemId);
		itemQuery.setParameter("oId", ownerId);

		List<ShopItem> items = itemQuery.getResultList();
		return items.get(0).getStock();
	}

	/**
	 * checks if the item is present in @OwnerCartItem
	 * 
	 * @param currentSession
	 * @param ownerId
	 * @param itemId
	 * @return boolean
	 */
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

	/**
	 * updates the quantity of stock based on changeBy value
	 * 
	 * @param currentSession
	 * @param ownerId
	 * @param itemId
	 * @param changeBy
	 * @return changes quantity
	 */
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

}
