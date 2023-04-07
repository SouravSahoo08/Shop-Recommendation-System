package com.souravsahoo.SRSproj.recommendation_module.recommendation_dao;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ShopItem;

public interface RecommendationService {

	List<ShopItem> zeroStockItems(String ownerId);

	List<ShopItem> expiredProductList(String ownerId);

	Long getTodaysTotalOrders(String ownerId);

	String getPeakSaleMonth(String ownerId);

}
