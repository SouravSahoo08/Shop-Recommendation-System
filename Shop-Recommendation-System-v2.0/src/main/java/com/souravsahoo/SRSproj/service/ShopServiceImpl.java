package com.souravsahoo.SRSproj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.dao.ShopDAO;
import com.souravsahoo.SRSproj.entity.OwnerCartItem;
import com.souravsahoo.SRSproj.entity.ShipmentDetails;
import com.souravsahoo.SRSproj.entity.ShopItem;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
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

	@Override
	@Transactional
	public void addItemToCart(ShopItem itemDetail, String ownerId) {
		shopDao.addItemToCart(itemDetail, ownerId);
	}

	@Override
	@Transactional
	public List<OwnerCartItem> showCart(String ownerId) {
		// TODO Auto-generated method stub
		return shopDao.showCart(ownerId);
	}

	@Override
	@Transactional
	public void removeItemFromCart(String ownerId, int itemId) {
		// TODO Auto-generated method stub
		shopDao.removeItemFromCart(ownerId, itemId);
	}
	
	@Override
	@Transactional
	public void add_to_orders(List<OwnerCartItem> cartItems, ShipmentDetails shipmentDetails, String ownerId) {
		// TODO Auto-generated method stub
		shopDao.add_to_orders(cartItems, shipmentDetails, ownerId);
	}

	@Override
	@Transactional
	public void emptyOwnerCart(String ownerId) {
		// TODO Auto-generated method stub
		shopDao.emptyOwnerCart(ownerId);
	}

	@Override
	@Transactional
	public void updateStocks(String ownerId, List<OwnerCartItem> cartItems) {
		// TODO Auto-generated method stub
		shopDao.updateStocks(ownerId, cartItems);
	}

}
