package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ShopItem;

public interface RecommendationDAO {

	List<ShopItem> zeroStockItems(String ownerId);

	List<ShopItem> expiredProductList(String ownerId);

	int getTodaysTotalOrders(String ownerId);

}
