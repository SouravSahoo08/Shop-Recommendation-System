package com.souravsahoo.SRSproj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.dao.UserShoppingDAO;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;

@Service //("userShopServiceImpl")
public class UserShopServiceImpl implements UserShopService {

	@Autowired
	//@Qualifier("userShoppingDAOImpl")
	private UserShoppingDAO userShoppingDao;

	@Override
	@Transactional
	public List<ShopItem> getItems() {
		// TODO Auto-generated method stub
		return userShoppingDao.getItems();
	}

	@Override
	@Transactional
	public ShopItem getItemDetail(int itemId) {
		return userShoppingDao.getItemDetail(itemId);
	}

	@Override
	@Transactional
	public void addItemToCart(ShopItem itemDetail, String userId) {
		// TODO Auto-generated method stub
		userShoppingDao.addItemToCart(itemDetail, userId);
	}

	@Override
	@Transactional
	public List<UserCartItem> getCartItems() {
		// TODO Auto-generated method stub
		return userShoppingDao.getCartItems();
	}

}
