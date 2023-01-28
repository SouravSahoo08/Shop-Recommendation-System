package com.souravsahoo.SRSproj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.dao.UserShoppingDAO;
import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.ShipmentDetails;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;

@Service // ("userShopServiceImpl")
public class UserShopServiceImpl implements UserShopService {

	@Autowired
	// @Qualifier("userShoppingDAOImpl")
	private UserShoppingDAO userShoppingDao;

	@Override
	@Transactional
	public List<ShopItem> getItems(String ownerId) {
		// TODO Auto-generated method stub
		return userShoppingDao.getItems(ownerId);
	}

	@Override
	@Transactional
	public ShopItem getItemDetail(int itemId, String ownerId) {
		return userShoppingDao.getItemDetail(itemId, ownerId);
	}

	@Override
	@Transactional
	public void addItemToCart(ShopItem itemDetail, String userId) {
		// TODO Auto-generated method stub
		userShoppingDao.addItemToCart(itemDetail, userId);
	}

	@Override
	@Transactional
	public List<UserCartItem> getCartItems(String userId) {
		// TODO Auto-generated method stub
		return userShoppingDao.getCartItems(userId);
	}

	@Override
	@Transactional
	public void removeItem(String userId, int itemId) {
		userShoppingDao.removeItem(userId, itemId);
	}

	@Override
	@Transactional
	public List<UserCartItem> showCart(String userId) {
		return userShoppingDao.showCart(userId);
	}

	@Override
	@Transactional
	public void emptyCart(String userId) {
		// TODO Auto-generated method stub
		userShoppingDao.emptyCart(userId);
	}

	@Override
	@Transactional
	public void add_to_orders(List<UserCartItem> cartItems, ShipmentDetails details, String ownerId) {
		userShoppingDao.add_to_orders(cartItems, details, ownerId);
	}

	@Override
	@Transactional
	public List<OwnerList> getOwners() {
		
		return userShoppingDao.getOwners();
	}

}
