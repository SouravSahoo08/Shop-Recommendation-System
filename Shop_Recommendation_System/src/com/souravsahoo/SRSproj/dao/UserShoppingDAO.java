package com.souravsahoo.SRSproj.dao;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;

public interface UserShoppingDAO {

	List<ShopItem> getItems(String ownerId);

	ShopItem getItemDetail(int itemId);

	void addItemToCart(ShopItem itemDetail, String userId);

	List<UserCartItem> getCartItems(String userId);

	void removeItem(String userId, int itemId);

	List<UserCartItem> showCart(String userId);

	void emptyCart(String userId);

}
