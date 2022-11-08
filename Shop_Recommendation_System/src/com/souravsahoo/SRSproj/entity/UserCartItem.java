package com.souravsahoo.SRSproj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_cart")
public class UserCartItem {

	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_type")
	private String itemType;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "price")
	private double itemPrice;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "exp_date")
	private String expDate;

	public UserCartItem() {
	}

	public UserCartItem(String userId, int itemId, String itemType, String itemName, double itemPrice, int quantity,
			String expDate) {

		this.userId = userId;
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
		this.expDate = expDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "UserCartItem [userId=" + userId + ", itemId=" + itemId + ", itemType=" + itemType + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + ", quantity=" + quantity + ", expDate=" + expDate + "]";
	}

}
