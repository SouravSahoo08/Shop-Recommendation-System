package com.souravsahoo.SRSproj.recommendation_module.recommendation_dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.entity.ProductInfo;
import com.souravsahoo.SRSproj.entity.ProductRecommendation;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.recommendation_module.recommendation_service.RecommendationDAO;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	private RecommendationDAO recommendationDAO;

	@Override
	@Transactional
	public List<ShopItem> zeroStockItems(String ownerId) {
		return recommendationDAO.zeroStockItems(ownerId);
	}

	@Override
	@Transactional
	public List<ShopItem> expiredProductList(String ownerId) {
		return recommendationDAO.expiredProductList(ownerId);
	}

	@Override
	@Transactional
	public Long getTodaysTotalOrders(String ownerId) {
		return recommendationDAO.getTodaysTotalOrders(ownerId);
	}

	@Override
	@Transactional
	public String getPeakSaleMonth(String ownerId) {
		// TODO Auto-generated method stub
		int month = recommendationDAO.getPeakSaleMonth(ownerId);
		switch (month) {
		case 1:
			return "January";

		case 2:
			return "February";

		case 3:
			return "March";

		case 4:
			return "April";

		case 5:
			return "May";

		case 6:
			return "June";

		case 7:
			return "July";

		case 8:
			return "August";

		case 9:
			return "September";

		case 10:
			return "October";

		case 11:
			return "November";

		case 12:
			return "December";

		default:
			break;
		}
		return "--";
	}

	@Override
	@Transactional
	public List<Double> getRevenueData(String ownerId, int year) {
		// TODO Auto-generated method stub
		return recommendationDAO.getRevenueData(ownerId, year);
	}

	@Override
	@Transactional
	public List<Object[]> getMostSoldProducts(String ownerId) {
		// TODO Auto-generated method stub
		return recommendationDAO.getMostSoldProducts(ownerId);
	}

	@Override
	@Transactional
	public List<Object[]> getLeastSoldProducts(String ownerId) {
		// TODO Auto-generated method stub
		return recommendationDAO.getLeastSoldProducts(ownerId);
	}

	@Override
	@Transactional
	public List<Object[]> getProfitableProducts(String ownerId) {
		// TODO Auto-generated method stub
		return recommendationDAO.getProfitableProducts(ownerId);
	}

	@Override
	@Transactional
	public List<ProductRecommendation> getItemsInBudgetRange(double maxBudget) {
		List<Object[]> salesData = recommendationDAO.getSalesData();

		Map<String, ProductInfo> productInfoMap = new HashMap<>();
		for (int i = 0; i < salesData.size(); i++) {
			String itemName = (String) salesData.get(i)[0];
			double averagePrice = (double) ((Integer) salesData.get(i)[2] / (Integer) salesData.get(i)[1]);
			int quantity = (Integer) salesData.get(i)[1];

			productInfoMap.put(itemName, new ProductInfo(averagePrice, quantity));
		}
		
		// Calculate the score for each product
		List<Map.Entry<String, ProductInfo>> sortedProducts = new ArrayList<>(productInfoMap.entrySet());
		Collections.sort(sortedProducts, (entry1, entry2) -> {
			double quantity1 = entry1.getValue().getQuantity();
		    double quantity2 = entry2.getValue().getQuantity();
		    return Double.compare(quantity2, quantity1); // Sort in descending order of the quantity
		});

		List<ProductRecommendation> filteredProducts = new ArrayList<>();
		double totalSum = 0.0;

		for (Map.Entry<String, ProductInfo> entry : sortedProducts) {
			String itemName = entry.getKey();
			double avgPrice = entry.getValue().getAveragePrice();
			int avgQuantity = entry.getValue().getQuantity();
			

			if (totalSum + avgPrice <= maxBudget) {
				filteredProducts.add(new ProductRecommendation(itemName, avgPrice, avgQuantity));
				totalSum += avgPrice;
			} else {
				// Adjust the quantity to fit within the budget
		        double remainingBudget = maxBudget - totalSum;
		        if (remainingBudget > 0) {
		            int adjustedQuantity = (int)Math.round(remainingBudget / avgPrice);
		            filteredProducts.add(new ProductRecommendation(itemName, avgPrice, adjustedQuantity));
		            totalSum += adjustedQuantity * avgPrice;
		        }
		        break; // Stop adding products once the budget limit is reached
			}
		}
		
		return filteredProducts;
	}

}
