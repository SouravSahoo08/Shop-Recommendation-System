package com.souravsahoo.SRSproj.entity;

/**
 * This class helps to combines data of two data models to merge and display in
 * the intended view page.
 * 
 * @category @ShopItem and @OwnerCartItem
 * @author jacky
 *
 */
public class CombinedDataModel {

	private int itemId;
	private String itemName;
	private double itemPrice;
	private String itemExpiryDate;
	private int quantity;

	public CombinedDataModel() {

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

	public String getItemExpiryDate() {
		return itemExpiryDate;
	}

	public void setItemExpiryDate(String itemExpiryDate) {
		this.itemExpiryDate = itemExpiryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
