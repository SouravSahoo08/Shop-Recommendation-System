package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souravsahoo.SRSproj.entity.ShopItem;

@Repository
public class RecommendationDAOImpl implements RecommendationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ShopItem> zeroStockItems(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ShopItem> zeroStockItemQuery = currentSession
				.createQuery("from ShopItem where lower(ownerId) = :oId and stock = 0", ShopItem.class);
		zeroStockItemQuery.setParameter("oId", ownerId);
		return zeroStockItemQuery.getResultList();
	}

}
