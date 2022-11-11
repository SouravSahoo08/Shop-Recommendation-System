package com.souravsahoo.SRSproj.service;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;

public interface UserShopService {

	List<ShopItem> getItems();

	ShopItem getItemDetail(int itemId);

	void addItemToCart(ShopItem itemDetail, String userId);

	List<UserCartItem> getCartItems(String userId);

	void removeItem(String string, int itemId);

	List<UserCartItem> showCart(String string);

	void emptyCart(String userId);

}
