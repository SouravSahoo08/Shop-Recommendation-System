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
	
	
}
