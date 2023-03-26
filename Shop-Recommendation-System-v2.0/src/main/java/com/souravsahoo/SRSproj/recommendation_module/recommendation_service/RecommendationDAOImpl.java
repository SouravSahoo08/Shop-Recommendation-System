package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.TimestampType;
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

	@Override
	public List<ShopItem> expiredProductList(String ownerId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		//String currentDate = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		
		Query<ShopItem> expiredProductListQuery = currentSession
				.createQuery("from ShopItem where lower(ownerId) = :oId and expDate < :currDate",ShopItem.class);
		expiredProductListQuery.setParameter("oId", ownerId);
		expiredProductListQuery.setParameter("currDate", new Date(), TimestampType.INSTANCE );
		
		return expiredProductListQuery.getResultList();
	}

}
