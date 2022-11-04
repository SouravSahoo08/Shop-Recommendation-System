package com.souravsahoo.SRSproj.service;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ShopItem;

public interface ShopService {

	List<ShopItem> getItems();

	void saveItem(ShopItem shopItem);

	ShopItem getItemDetail(int itemId);

	void deleteItem(int itemId);

}
