package com.souravsahoo.SRSproj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.dao.ShopDAO;
import com.souravsahoo.SRSproj.entity.ShopItem;

@Service //("shopServiceImpl")
public class ShopServiceImpl implements ShopService{

	@Autowired
	//@Qualifier("shopDAOImpl")
	private ShopDAO shopDao; 
	
	@Override
	@Transactional
	public List<ShopItem> getItems(String ownerId) {
		return shopDao.getItems(ownerId);
	}

	@Override
	@Transactional
	public void saveItem(ShopItem shopItem) {
		shopDao.saveItem(shopItem);
	}

	@Override
	@Transactional
	public ShopItem getItemDetail(int itemId,String ownerId) {
		return shopDao.getItemDetail(itemId, ownerId);
	}

	@Override
	@Transactional
	public void deleteItem(int itemId, String ownerId) {
		shopDao.deleteItem(itemId, ownerId);
	}

	@Override
	@Transactional
	public List<ShopItem> searchItem(String searchItemName,String ownerId) {
		return shopDao.searchItem(searchItemName, ownerId);
	}

}
