package com.souravsahoo.SRSproj.entity;

public class ProductInfo {
	private String itemType;
	private String itemName;
	private double itemPrice;
	private int total_quantity_sold;

	public ProductInfo(String itemType, String itemName, double itemPrice, int total_quantity_sold) {
		super();
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.total_quantity_sold = total_quantity_sold;
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

	public int getTotal_quantity_sold() {
		return total_quantity_sold;
	}

	public void setTotal_quantity_sold(int total_quantity_sold) {
		this.total_quantity_sold = total_quantity_sold;
	}

}
