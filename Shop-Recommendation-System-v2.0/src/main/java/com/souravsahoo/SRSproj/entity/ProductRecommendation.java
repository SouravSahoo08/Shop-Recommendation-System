package com.souravsahoo.SRSproj.entity;

public class ProductRecommendation {
	private String itemType;
	private String itemName;
	private double itemPrice;
	private int quantity;

	
	
	public ProductRecommendation() {
		super();
	}

	public ProductRecommendation(String itemType, String itemName, double itemPrice, int quantity) {
		super();
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
