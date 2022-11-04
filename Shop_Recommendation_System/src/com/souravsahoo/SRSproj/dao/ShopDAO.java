package com.souravsahoo.SRSproj.dao;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ShopItem;

public interface ShopDAO {

	List<ShopItem> getItems();

	void saveItem(ShopItem shopItem);

	ShopItem getItemDetail(int itemId);

	void deleteItem(int itemId);

}
