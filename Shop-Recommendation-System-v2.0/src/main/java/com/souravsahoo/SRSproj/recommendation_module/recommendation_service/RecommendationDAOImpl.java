package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

import java.util.Calendar;
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

	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	private static final int CURRENT_MONTH = 3;

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
				+ "GROUP BY YEAR(o.orderDate), MONTH(o.orderDate) " + "ORDER BY SUM(o.price * o.quantity) DESC",
				Integer.class).setMaxResults(1).getResultList();

		System.out.println("LOG >> Peak revenue Month : " + month.get(0));
		return month.get(0);
	}

	@Override
	public List<Double> getRevenueData(String ownerId, int year) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Double> revenueQuery = currentSession.createQuery("SELECT SUM(o.price * o.quantity) AS revenue "
				+ "FROM Orders o " + "WHERE YEAR(o.orderDate) = :year "
				+ "GROUP BY YEAR(o.orderDate), MONTH(o.orderDate) " + "ORDER BY YEAR(o.orderDate), MONTH(o.orderDate)",
				Double.class);
		revenueQuery.setParameter("year", year);

		List<Double> revenueData = revenueQuery.getResultList();
		System.out.println(revenueData);
		return revenueData;
	}

	@Override
	public List<Object[]> getMostSoldProducts(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		String hql = "SELECT o.itemId AS itemId, o.productLine AS productLine, o.itemType AS itemType, o.itemName AS itemName, SUM(o.quantity) AS totalQuantity "
				+ "FROM Orders o where year(o.orderDate) != :year and month(o.orderDate) = :month and ownerId = :oId "
				+ "GROUP BY itemName ORDER BY totalQuantity DESC";

		List<Object[]> mostSoldProducts = currentSession.createQuery(hql, Object[].class)
				.setParameter("year", CURRENT_YEAR).setParameter("month", CURRENT_MONTH).setParameter("oId", ownerId)
				.setMaxResults(10).getResultList();

		return mostSoldProducts;
	}

	@Override
	public List<Object[]> getLeastSoldProducts(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		String hql = "SELECT o.itemId AS itemId, o.productLine AS productLine, o.itemType AS itemType, o.itemName AS itemName, SUM(o.quantity) AS totalQuantity "
				+ "FROM Orders o where year(o.orderDate) != :year and month(o.orderDate) = :month and ownerId = :oId "
				+ "GROUP BY itemName ORDER BY totalQuantity ASC";

		List<Object[]> leastSoldProducts = currentSession.createQuery(hql, Object[].class)
				.setParameter("year", CURRENT_YEAR).setParameter("month", CURRENT_MONTH).setParameter("oId", ownerId)
				.setMaxResults(10).getResultList();

		return leastSoldProducts;
	}

	@Override
	public List<Object[]> getProfitableProducts(String ownerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		String hql = "SELECT o.itemId AS itemId, o.productLine AS productLine, o.itemType AS itemType, o.itemName AS itemName, SUM(o.price * o.quantity - s.price * o.quantity) AS profit "
				+ "FROM Orders o JOIN ShopItem s ON o.itemId = s.itemId WHERE o.ownerId = :oId "
				+ "GROUP BY o.itemId ORDER BY profit DESC";

		List<Object[]> profitableProducts = currentSession.createQuery(hql, Object[].class).setParameter("oId", ownerId)
				.getResultList();
		return profitableProducts;
	}

}
