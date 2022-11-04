package com.souravsahoo.SRSproj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.dao.ShopDAO;
import com.souravsahoo.SRSproj.entity.ShopItem;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDAO shopDao; 
	
	@Override
	@Transactional
	public List<ShopItem> getItems() {
		return shopDao.getItems();
	}

	@Override
	@Transactional
	public void saveItem(ShopItem shopItem) {
		shopDao.saveItem(shopItem);
	}

	@Override
	@Transactional
	public ShopItem getItemDetail(int itemId) {
		return shopDao.getItemDetail(itemId);
	}

	@Override
	@Transactional
	public void deleteItem(int itemId) {
		shopDao.deleteItem(itemId);
	}

	@Override
	@Transactional
	public List<ShopItem> searchItem(String searchItemName) {
		return shopDao.searchItem(searchItemName);
	}

}
