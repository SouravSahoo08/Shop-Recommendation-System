package com.souravsahoo.SRSproj.recommendation_module.recommendation_service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravsahoo.SRSproj.entity.ProductInfo;
import com.souravsahoo.SRSproj.entity.ProductRecommendation;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.recommendation_module.recommendation_dao.RecommendationDAO;

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
	public List<Object[]> getPeakSaleMonthItems(String ownerId){
		int month = recommendationDAO.getPeakSaleMonth(ownerId);
		return recommendationDAO.getPeakSaleMonthItemList(ownerId,month);
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
		List<Object[]> salesData = recommendationDAO.getSalesDataForBudgetRecommendation();

		List<ProductInfo> products = new ArrayList<>();
		double[] itemPriceList = new double[salesData.size()];
		double[] totalQuantitySoldList = new double[salesData.size()];

		for (int i = 0; i < salesData.size(); i++) {
			String itemType = salesData.get(i)[0].toString();
			String itemName = salesData.get(i)[1].toString();
			double itemPrice = (double) salesData.get(i)[2];
			int total_quantity_sold = ((Long) salesData.get(i)[3]).intValue();

			itemPriceList[i] = itemPrice;
			totalQuantitySoldList[i] = total_quantity_sold;
			products.add(new ProductInfo(itemType, itemName, itemPrice, total_quantity_sold));
		}

		double[] itemConstant = new double[salesData.size()];
		for (int i = 0; i < itemConstant.length; i++)
			itemConstant[i] = 1.0;

		List<LinearConstraint> itemQuantityConstraintList = new ArrayList<LinearConstraint>();
		/*
		 * for (int i = 0; i < salesData.size(); i++) { itemQuantityConstraintList
		 * .add(new LinearConstraint(new double[] { 1.0 }, Relationship.LEQ,
		 * totalQuantitySoldList[i])); }
		 */

		itemQuantityConstraintList.add(new LinearConstraint(itemPriceList,Relationship.LEQ,maxBudget));
		itemQuantityConstraintList.add(new LinearConstraint(new double[] { 1.0 }, Relationship.GEQ, 1.0));

		// Create the linear programming problem
		LinearObjectiveFunction objectiveFunction = new LinearObjectiveFunction(new ArrayRealVector(itemPriceList),
				0.0);
		LinearConstraintSet constraints = new LinearConstraintSet(itemQuantityConstraintList);

		// Set up the solver
		PointValuePair solution = new SimplexSolver().optimize( 
				objectiveFunction, constraints, GoalType.MAXIMIZE);

		// Get the solution
		double[] quantities = solution.getPoint();
		List<ProductRecommendation> recommendedItems = new ArrayList<>();

		for (int i = 0; i < products.size(); i++) {
			recommendedItems.add(new ProductRecommendation(products.get(i).getItemType(), products.get(i).getItemName(),
					products.get(i).getItemPrice(), (int) Math.round(quantities[i])));
		}

		return recommendedItems;
	}

}

/*
 * import org.apache.commons.math3.optim.*; import
 * org.apache.commons.math3.optim.linear.*; import
 * org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
 * 
 * public class LinearProgrammingExample {
 * 
 * public static void main(String[] args) { // Define the item prices and budget
 * constraint double[] itemPrices = {10.0, 15.0, 20.0, 25.0, 30.0}; // Example
 * item prices double budgetConstraint = 100.0; // Example budget constraint
 * 
 * // Create the linear programming problem LinearObjectiveFunction
 * objectiveFunction = new LinearObjectiveFunction(new
 * double[itemPrices.length], 0.0); for (int i = 0; i < itemPrices.length; i++)
 * { objectiveFunction.setCoefficient(i, itemPrices[i]); }
 * 
 * LinearConstraintSet constraints = new LinearConstraintSet();
 * constraints.addConstraint(new LinearConstraint(itemPrices, Relationship.LEQ,
 * budgetConstraint));
 * 
 * // Set up the solver PointValuePair solution = new SimplexSolver().optimize(
 * new MaxIter(100), // Maximum number of iterations objectiveFunction,
 * constraints, GoalType.MAXIMIZE );
 * 
 * // Get the solution double[] quantities = solution.getPoint();
 * 
 * // Print the recommended items and their quantities for (int i = 0; i <
 * itemPrices.length; i++) { System.out.println("Item " + (i + 1) +
 * ": Quantity = " + quantities[i]); } } }
 * 
 * 
 * 
 * List<ProductRecommendation> recommendedItems = new ArrayList<>(); while
 * (!productQueue.isEmpty() && maxBudget > 0) { ProductInfo product =
 * productQueue.poll(); double itemPrice = product.getItemPrice();
 * 
 * if (itemPrice <= maxBudget) { int quantity = (int) (maxBudget / itemPrice);
 * recommendedItems.add(new ProductRecommendation( product.getItemType(),
 * product.getItemName(), itemPrice, quantity)); //maxBudget -= itemPrice *
 * quantity; maxBudget %= (itemPrice * quantity); } }
 * 
 */
