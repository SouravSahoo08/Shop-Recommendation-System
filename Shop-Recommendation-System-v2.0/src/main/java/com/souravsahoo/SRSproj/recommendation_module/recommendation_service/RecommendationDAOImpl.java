package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendationDAOImpl implements RecommendationDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean zeroStockItems(String ownerId) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
