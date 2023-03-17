package com.souravsahoo.SRSproj.dao;

import java.util.List;

import com.souravsahoo.SRSproj.entity.OwnerCartItem;
import com.souravsahoo.SRSproj.entity.ShipmentDetails;
import com.souravsahoo.SRSproj.entity.ShopItem;

public interface ShopDAO {

	List<ShopItem> getItems(String ownerId);

	void saveItem(ShopItem shopItem);

	void deleteItem(int itemId, String ownerId);

	List<ShopItem> searchItem(String searchItemName, String ownerId);

	ShopItem getItemDetail(int itemId, String ownerId);

	void addItemToCart(ShopItem itemDetail, String ownerId);

	List<OwnerCartItem> showCart(String ownerId);

	void removeItemFromCart(String ownerId, int itemId);

	void add_to_orders(List<OwnerCartItem> cartItems, ShipmentDetails shipmentDetails, String ownerId);

	void emptyOwnerCart(String ownerId);

	void updateStocks(String ownerId, List<OwnerCartItem> cartItems);
}
