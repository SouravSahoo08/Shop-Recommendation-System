package com.souravsahoo.SRSproj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.dao.UserShoppingDAO;
import com.souravsahoo.SRSproj.entity.ShopItem;

@Service
public class UserShopServiceImpl implements UserShopService {

	@Autowired
	private UserShoppingDAO userShoppingDao;
	
	@Override
	@Transactional
	public List<ShopItem> getItems() {
		// TODO Auto-generated method stub
		return userShoppingDao.getItems();
	}

}
