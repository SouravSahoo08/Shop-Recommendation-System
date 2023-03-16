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

	public Orders(int orderId, String ownerId, String userId, int itemId, String itemName, double price, int quantity,
			String expDate, String orderDate) {
		super();
		this.orderNo = orderId;
		this.ownerId = ownerId;
		this.userId = userId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.expDate = expDate;
		this.orderDate = orderDate;
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
		return "Orders [orderId=" + orderNo + ", ownerId=" + ownerId + ", userId=" + userId + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + ", expDate=" + expDate
				+ ", orderDate=" + orderDate + "]";
	}

}
