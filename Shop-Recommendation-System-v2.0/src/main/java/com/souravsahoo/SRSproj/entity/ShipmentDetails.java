package com.souravsahoo.SRSproj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shipment_detail")
public class ShipmentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipment_id")
	private int shipmentId;

	@NotEmpty(message = "Cannot be empty")
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "address")
	private String address;

	@Pattern(regexp = "(^$|[0-9]{6})", message = "check pincode")
	@Column(name = "pincode")
	private String pincode;

	@Pattern(regexp = "(^$|[0-9]{10})", message = "should be a 10 digit number")
	@Column(name = "contact_no")
	private String contactNo;

	@OneToOne(mappedBy = "shipmentDetail", cascade = CascadeType.ALL)
	private Orders order;

	public ShipmentDetails() {
	}

	public ShipmentDetails(int shipmentId, @NotNull(message = "Cannot be empty") String customerName,
			@NotNull(message = "Cannot be empty") String address,
			@Size(min = 6, message = "check pincode") String pincode,
			@Size(min = 10, message = "Should be a 10 digit number") String contactNo, Orders order) {
		super();
		this.shipmentId = shipmentId;
		this.customerName = customerName;
		this.address = address;
		this.pincode = pincode;
		this.contactNo = contactNo;
		this.order = order;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "ShipmentDetails [shipmentId=" + shipmentId + ", customerName=" + customerName + ", address=" + address
				+ ", pincode=" + pincode + ", contactNo=" + contactNo + ", order=" + order + "]";
	}

}