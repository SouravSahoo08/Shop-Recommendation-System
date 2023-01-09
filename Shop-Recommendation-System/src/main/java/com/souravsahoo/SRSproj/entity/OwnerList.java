package com.souravsahoo.SRSproj.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "owner_list")
public class OwnerList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_no")
	private int slNo;

	@Column(name = "owner_id")
	private String ownerId;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "license_no")
	private String licenseNo;

	@Column(name = "age")
	private int age;

	@Column(name = "phone")
	private long phoneNo;

	@Column(name = "shop_type")
	private String shopType;

	@Column(name = "shop_Address")
	private String shopAddress;

	@Column(name = "username")
	private String sUsername;

	@Column(name = "pwd")
	private String sPwd;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public OwnerList() {

	}

	public OwnerList(int slNo, String ownerId, String ownerName, String licenseNo, int age, long phoneNo,
			String shopType, String shopAddress, String sUsername, String sPwd) {
		super();
		this.slNo = slNo;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.licenseNo = licenseNo;
		this.age = age;
		this.phoneNo = phoneNo;
		this.shopType = shopType;
		this.shopAddress = shopAddress;
		this.sUsername = sUsername;
		this.sPwd = sPwd;
	}

	public OwnerList(int slNo, String ownerId, String ownerName, String licenseNo, int age, int phoneNo,
			String shopType, String shopAddress, String sUsername, String sPwd, Collection<Role> roles) {
		super();
		this.slNo = slNo;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.licenseNo = licenseNo;
		this.age = age;
		this.phoneNo = phoneNo;
		this.shopType = shopType;
		this.shopAddress = shopAddress;
		this.sUsername = sUsername;
		this.sPwd = sPwd;
		this.roles = roles;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getsUsername() {
		return sUsername;
	}

	public void setsUsername(String sUsername) {
		this.sUsername = sUsername;
	}

	public String getsPwd() {
		return sPwd;
	}

	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "OwnerList [slNo=" + slNo + ", ownerId=" + ownerId + ", ownerName=" + ownerName + ", licenseNo="
				+ licenseNo + ", age=" + age + ", phoneNo=" + phoneNo + ", shopType=" + shopType + ", shopAddress="
				+ shopAddress + ", sUsername=" + sUsername + ", sPwd=" + sPwd + ", roles=" + roles + "]";
	}

}
