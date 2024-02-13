package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

import java.util.List;

import com.souravsahoo.SRSproj.entity.ProductRecommendation;
import com.souravsahoo.SRSproj.entity.ShopItem;

public interface RecommendationService {

	List<ShopItem> zeroStockItems(String ownerId);

	List<ShopItem> expiredProductList(String ownerId);

	Long getTodaysTotalOrders(String ownerId);

	String getPeakSaleMonth(String ownerId);

	List<Double> getRevenueData(String ownerId, int year);

	List<Object[]> getMostSoldProducts(String ownerId);

	List<Object[]> getLeastSoldProducts(String ownerId);

	List<Object[]> getProfitableProducts(String ownerId);

	List<ProductRecommendation> getItemsInBudgetRange(double maxBudget);

	List<Object[]> getPeakSaleMonthItems(String ownerId);

}
