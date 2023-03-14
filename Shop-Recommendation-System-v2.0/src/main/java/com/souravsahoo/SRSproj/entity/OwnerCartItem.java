package com.souravsahoo.SRSproj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner_cart")
public class OwnerCartItem {

	@Id
	@Column(name = "sl_no")
	private int slNo;

	@Column(name = "owner_id")
	private String ownerId;

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

	public OwnerCartItem() {
	}

	public OwnerCartItem(int slNo, String ownerId, int itemId, String itemType, String itemName, double itemPrice,
			int quantity, String expDate) {
		super();
		this.slNo = slNo;
		this.ownerId = ownerId;
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
		this.expDate = expDate;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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
		return "OwnerCartItem [slNo=" + slNo + ", ownerId=" + ownerId + ", itemId=" + itemId + ", itemType=" + itemType
				+ ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", quantity=" + quantity + ", expDate="
				+ expDate + "]";
	}

}
