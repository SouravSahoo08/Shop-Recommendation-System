package com.souravsahoo.SRSproj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "shop1_list")
public class ShopItem {

	/*
	 * `item_id` int(11) NOT NULL AUTO_INCREMENT, `item_type` varchar(10) default
	 * null, `item_name` varchar(20) not null, `price` double(5,2) not null,
	 * `exp_date` date not null,
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "product_line")
	private String productLine;
	
	@NotNull(message = "Cannot be empty")
	@Column(name = "item_type")
	private String itemType;

	@NotNull(message = "Cannot be empty")
	@Column(name = "item_name")
	private String itemName;

	@Positive(message = "price cannot be zero")
	@Column(name = "price")
	private double price;

	@Positive(message = "price cannot be zero")
	@Column(name = "sp")
	private double sellingPrice;
	
	@NotNull(message = "Cannot be empty")
	@Column(name = "exp_date")
	private String expDate;

	@Column(name = "owner_id")
	private String ownerId;

	@Column(name = "stock")
	private int stock;

	public ShopItem() {

	}

	public ShopItem(int itemId) {
		this.itemId = itemId;
	}

	public ShopItem(int itemId, String productLine, @NotNull(message = "Cannot be empty") String itemType,
			@NotNull(message = "Cannot be empty") String itemName,
			@Positive(message = "price cannot be zero") double price,
			@Positive(message = "price cannot be zero") double sellingPrice,
			@NotNull(message = "Cannot be empty") String expDate, String ownerId, int stock) {
		super();
		this.itemId = itemId;
		this.productLine = productLine;
		this.itemType = itemType;
		this.itemName = itemName;
		this.price = price;
		this.sellingPrice = sellingPrice;
		this.expDate = expDate;
		this.ownerId = ownerId;
		this.stock = stock;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
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

	public double getPrice() {
		return Double.parseDouble(String.format("%5.2f", price));
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ShopItem [itemId=" + itemId + ", productLine=" + productLine + ", itemType=" + itemType + ", itemName="
				+ itemName + ", price=" + price + ", sellingPrice=" + sellingPrice + ", expDate=" + expDate
				+ ", ownerId=" + ownerId + ", stock=" + stock + "]";
	}

}
