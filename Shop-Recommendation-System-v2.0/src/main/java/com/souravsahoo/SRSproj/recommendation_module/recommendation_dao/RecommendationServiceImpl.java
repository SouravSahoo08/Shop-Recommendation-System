package com.souravsahoo.SRSproj.recommendation_module.recommendation_dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return recommendationDAO.getRevenueData(ownerId,year);
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

}
