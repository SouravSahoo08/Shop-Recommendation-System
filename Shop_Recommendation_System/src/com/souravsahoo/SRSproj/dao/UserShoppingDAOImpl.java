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
	public List<ShopItem> getItems() {

		Session currentSession = sessionFactory.getCurrentSession();
		List<ShopItem> items = currentSession.createQuery("from ShopItem", ShopItem.class).getResultList();
		return items;
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
	public void addItemToCart(ShopItem itemDetail, String userId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		UserCartItem cartItem = new UserCartItem();
		cartItem.setUserId(userId);
		cartItem.setItemId(itemDetail.getItemId());
		cartItem.setItemType(itemDetail.getItemType());
		cartItem.setItemName(itemDetail.getItemName());
		cartItem.setItemPrice(itemDetail.getPrice());
		cartItem.setQuantity(isItemPresent(currentSession, userId, itemDetail.getItemId()));
		cartItem.setExpDate(itemDetail.getExpDate());
		
		System.out.println("UserShoppingDao: addItemToCart ====> " +cartItem);
		
		currentSession.saveOrUpdate(cartItem);
	}
	
	private int isItemPresent(Session currentSession, String userId, int itemId) {
		int quantity=1;
		Query<UserCartItem> checkItemQuery = currentSession.createQuery("from UserCartItem where " + 
					"lower(userId) = :uId " +
					"and itemId = :uItemId order by quantity", UserCartItem.class);
		checkItemQuery.setParameter("uId", userId.toLowerCase());
		checkItemQuery.setParameter("uItemId", itemId);
		List<UserCartItem> foundItemInCart = checkItemQuery.getResultList();
		System.out.println("\n\ncart list ===> "+foundItemInCart);
		if(foundItemInCart.isEmpty())
			return 1;
		else {
			String query = "from UserCartItem where quantity = "
					+ "(select max(quantity) from UserCartItem where quantity in "
					+ "(select quantity from UserCartItem where lower(userId) = :uId and itemId = :uItemId order by quantity))";
			
			Query<UserCartItem> quantityQuery = currentSession.createQuery(query,UserCartItem.class);
			quantityQuery.setParameter("uId", userId.toLowerCase());
			quantityQuery.setParameter("uItemId", itemId);
			
			List<UserCartItem> itemWithMaxQuantity = quantityQuery.getResultList();
			System.out.println("\n\nitemWithMaxQuantity ===> "+itemWithMaxQuantity);
			
			UserCartItem item = itemWithMaxQuantity.get(0);
			quantity =item.getQuantity() + 1;
			System.out.println("Quantity : " + quantity);
			
		}
		
		return quantity;
	}

	@Override
	public List<UserCartItem> getCartItems(String userId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserCartItem> getCartItemQuery = 
				currentSession.createQuery("from UserCartItem where lower(userId) = :uName", UserCartItem.class);
		getCartItemQuery.setParameter("uName", userId);
		List<UserCartItem> itemList = getCartItemQuery.getResultList();
		
		System.out.println("UserShoppingDAO: getCartItems ====> " + itemList);
		return itemList;
	}
}
