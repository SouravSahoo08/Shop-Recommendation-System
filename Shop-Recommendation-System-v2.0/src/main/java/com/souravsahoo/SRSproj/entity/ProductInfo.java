package com.souravsahoo.SRSproj.entity;

public class ProductInfo {
	private double averagePrice; 
	private int quantity;
	
	
	public ProductInfo() {
		super();
	}

	public ProductInfo(double averagePrice, int quantity) {
		super();
		this.averagePrice = averagePrice;
		this.quantity = quantity;
	}

	public double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
