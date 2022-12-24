package com.souravsahoo.SRSproj.service;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ShopItem;

public interface ShopService {

	List<ShopItem> getItems(String ownerId);

	void saveItem(ShopItem shopItem);

	ShopItem getItemDetail(int itemId, String ownerId);

	void deleteItem(int itemId, String ownerId);

	List<ShopItem> searchItem(String searchItemName, String ownerId);

}
