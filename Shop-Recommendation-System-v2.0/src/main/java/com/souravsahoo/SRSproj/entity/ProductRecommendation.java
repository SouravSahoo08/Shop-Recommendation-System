package com.souravsahoo.SRSproj.entity;

public class ProductRecommendation {
	private String itemName;
	private double avgPrice;
	private int quantity;
	

	public ProductRecommendation() {
		super();
	}


	public ProductRecommendation(String itemName, double avgPrice, int quantity) {
		super();
		this.itemName = itemName;
		this.avgPrice = avgPrice;
		this.quantity = quantity;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getAvgPrice() {
		return avgPrice;
	}


	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
