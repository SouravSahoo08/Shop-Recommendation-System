package com.souravsahoo.SRSproj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
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

	@NotNull(message="Cannot be empty")
	@Column(name = "item_type")
	private String itemType;

	@NotNull(message="Cannot be empty")
	@Column(name = "item_name")
	private String itemName;

	@Positive(message="price cannot be zero")
	@Column(name = "price")
	private double price;

	@NotNull(message="Cannot be empty")
	@Column(name = "exp_date")
	private String expDate;

	public ShopItem() {

	}

	public ShopItem(String itemType, String itemName, double price, String expDate) {
		super();
		this.itemType = itemType;
		this.itemName = itemName;
		this.price = price;
		this.expDate = expDate;
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

	public double getPrice() {
		return Double.parseDouble(String.format("%5.2f", price));
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Shop_1_Item [itemId=" + itemId + ", itemType=" + itemType + ", itemName=" + itemName + ", price="
				+ price + ", expDate=" + expDate + "]";
	}

}
