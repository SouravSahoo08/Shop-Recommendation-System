package com.souravsahoo.SRSproj.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_no")
	private int orderNo;

	@Column(name = "owner_id")
	private String ownerId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "product_line")
	private String productLine;

	@Column(name = "item_type")
	private String itemType;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "exp_date")
	private String expDate;

	@Column(name = "order_date")
	private String orderDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipment_id")
	private ShipmentDetails shipmentDetail;

	public Orders() {

	}

	public Orders(int orderNo, String ownerId, String userId, int itemId, String productLine, String itemType,
			String itemName, double price, int quantity, String expDate, String orderDate,
			ShipmentDetails shipmentDetail) {
		super();
		this.orderNo = orderNo;
		this.ownerId = ownerId;
		this.userId = userId;
		this.itemId = itemId;
		this.productLine = productLine;
		this.itemType = itemType;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.expDate = expDate;
		this.orderDate = orderDate;
		this.shipmentDetail = shipmentDetail;
	}

	public int getOrderId() {
		return orderNo;
	}

	public void setOrderId(int orderId) {
		this.orderNo = orderId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public ShipmentDetails getShipmentDetail() {
		return shipmentDetail;
	}

	public void setShipmentDetail(ShipmentDetails shipmentDetail) {
		this.shipmentDetail = shipmentDetail;
	}

	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", ownerId=" + ownerId + ", userId=" + userId + ", itemId=" + itemId
				+ ", productLine=" + productLine + ", itemType=" + itemType + ", itemName=" + itemName + ", price="
				+ price + ", quantity=" + quantity + ", expDate=" + expDate + ", orderDate=" + orderDate
				+ ", shipmentDetail=" + shipmentDetail + "]";
	}

}