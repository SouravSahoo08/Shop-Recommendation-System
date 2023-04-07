package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

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
		Query<ShopItem> expiredProductListQuery = currentSession
				.createQuery("from ShopItem where lower(ownerId) = :oId and expDate < :currDate", ShopItem.class);
		expiredProductListQuery.setParameter("oId", ownerId);
		expiredProductListQuery.setParameter("currDate", new Date(), TimestampType.INSTANCE);

		return expiredProductListQuery.getResultList();
	}

	@Override
	public Long getTodaysTotalOrders(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Long totalOrders = (Long) currentSession
				.createQuery("select count(*) from Orders where ownerId = :oId and orderDate = :currDate")
				.setParameter("oId", ownerId).setParameter("currDate", new Date(), TimestampType.INSTANCE)
				// .setParameter("currDate", "2019-03-05") // for demo purpose
				.uniqueResult();

		System.out.println("LOG >> total orders : " + totalOrders);
		return totalOrders;
	}

	@Override
	public int getPeakSaleMonth(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Integer> month = currentSession.createQuery("SELECT MONTH(o.orderDate) " + "FROM Orders o "
						+ "GROUP BY YEAR(o.orderDate), MONTH(o.orderDate) " + "ORDER BY SUM(o.price * o.quantity) DESC", Integer.class)
				.setMaxResults(1)
				.getResultList();

		System.out.println("LOG >> Peak revenue Month : " +month.get(0));
		return month.get(0);
	}

}
