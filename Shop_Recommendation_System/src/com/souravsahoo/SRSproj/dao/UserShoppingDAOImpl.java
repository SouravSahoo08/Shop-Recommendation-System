package com.souravsahoo.SRSproj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;

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
	public List<ShopItem> getItems(String ownerId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<ShopItem> getItemsQuery = currentSession.createQuery("from ShopItem where lower(ownerId) = :oId",
				ShopItem.class);
		getItemsQuery.setParameter("oId", ownerId);
		List<ShopItem> items = getItemsQuery.getResultList();
		return items;
	}

	/**
	 * returns the details of a particular item
	 * 
	 * @return @ShopItem object
	 */
	@Override
	public ShopItem getItemDetail(int itemId, String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<ShopItem> getItemDetailQuery = currentSession.createQuery("from ShopItem where lower(ownerId) = :oId and itemId = := itemId", ShopItem.class);
		getItemDetailQuery.setParameter("oId", ownerId);		
		getItemDetailQuery.setParameter("itemId", itemId);
		List<ShopItem> items = getItemDetailQuery.getResultList();
		
		return items.get(0);
	}

	@Override
	public void addItemToCart(ShopItem itemDetail, String userId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		boolean isItemPresent = checkIfItemPresent(currentSession, userId, itemDetail.getItemId());

		if (isItemPresent) {
			int quantity = updateQuantity(currentSession, userId, itemDetail.getItemId(), 1);
			Query<?> updateItemQuery = currentSession.createQuery(
					"update UserCartItem set quantity = :uQuant where lower(userId) = :uId and itemId = :uItemId");

			updateItemQuery.setParameter("uQuant", quantity);
			updateItemQuery.setParameter("uId", userId.toLowerCase());
			updateItemQuery.setParameter("uItemId", itemDetail.getItemId());
			updateItemQuery.executeUpdate();

		} else {
			UserCartItem cartItem = new UserCartItem();
			cartItem.setUserId(userId);
			cartItem.setItemId(itemDetail.getItemId());
			cartItem.setItemType(itemDetail.getItemType());
			cartItem.setItemName(itemDetail.getItemName());
			cartItem.setItemPrice(itemDetail.getPrice());
			cartItem.setQuantity(1);
			cartItem.setExpDate(itemDetail.getExpDate());

			System.out.println("UserShoppingDao: addItemToCart ====> " + cartItem);
			currentSession.save(cartItem);
		}

	}

	private boolean checkIfItemPresent(Session currentSession, String userId, int itemId) {

		Query<UserCartItem> checkItemQuery = currentSession.createQuery(
				"from UserCartItem where " + "lower(userId) = :uId " + "and itemId = :uItemId order by quantity",
				UserCartItem.class);
		checkItemQuery.setParameter("uId", userId.toLowerCase());
		checkItemQuery.setParameter("uItemId", itemId);
		List<UserCartItem> foundItemInCart = checkItemQuery.getResultList();
		System.out.println("\n\ncart list ===> " + foundItemInCart);
		if (foundItemInCart.isEmpty()) {
			// if same itemId item is not present
			return false;
		}

		return true;
	}

	private int updateQuantity(Session currentSession, String userId, int itemId, int changeBy) {

		int quantity;

		String query = "from UserCartItem where lower(userId) = :uId and itemId = :uItemId";
		Query<UserCartItem> quantityQuery = currentSession.createQuery(query, UserCartItem.class);
		quantityQuery.setParameter("uId", userId.toLowerCase());
		quantityQuery.setParameter("uItemId", itemId);

		List<UserCartItem> itemWithMaxQuantity = quantityQuery.getResultList();
		System.out.println("\n\nitemWithMaxQuantity ===> " + itemWithMaxQuantity);

		UserCartItem item = itemWithMaxQuantity.get(0);
		quantity = item.getQuantity() + changeBy;
		System.out.println("Quantity : " + quantity);

		return quantity;
	}

	@Override
	public List<UserCartItem> getCartItems(String userId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserCartItem> createQuery = currentSession.createQuery("from UserCartItem where lower(userId) = :uName",
				UserCartItem.class);
		createQuery.setParameter("uName", userId);
		List<UserCartItem> items = createQuery.getResultList();

		return items;
	}

	@Override
	public void removeItem(String userId, int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<UserCartItem> getItemQuery = currentSession
				.createQuery("from UserCartItem where lower(userId) = :uId and itemId = :uItemId", UserCartItem.class);
		getItemQuery.setParameter("uId", userId.toLowerCase());
		getItemQuery.setParameter("uItemId", itemId);

		List<UserCartItem> itemList = getItemQuery.getResultList();
		System.out.println("\n\nitemList ===> " + itemList);

		UserCartItem item = itemList.get(0);

		if (item.getQuantity() > 1)
			item.setQuantity(updateQuantity(currentSession, userId, itemId, -1));
		else
			currentSession.delete(item);

	}

	@Override
	public List<UserCartItem> showCart(String userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserCartItem> createQuery = currentSession.createQuery("from UserCartItem where lower(userId) = :uId",
				UserCartItem.class);
		createQuery.setParameter("uId", userId);
		List<UserCartItem> items = createQuery.getResultList();

		return items;
	}

	@Override
	public void emptyCart(String userId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> emptyCartQuery = currentSession.createQuery("delete from UserCartItem where lower(userId) = :uId");
		emptyCartQuery.setParameter("uId", userId);
		emptyCartQuery.executeUpdate();
	}
}
