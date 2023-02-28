package com.souravsahoo.SRSproj.Crm_package;

public class CrmOwner {

	private String ownerName;
	private String licenseNo;
	private int age;
	private int phoneNo;
	private String shopType;
	private String shopAddress;
	private String sUsername;
	private String sPwd;
	
	public CrmOwner() {}

	public CrmOwner(String ownerName, String licenseNo, int age, int phoneNo, String shopType, String shopAddress,
			String sUsername, String sPwd) {
		super();
		this.ownerName = ownerName;
		this.licenseNo = licenseNo;
		this.age = age;
		this.phoneNo = phoneNo;
		this.shopType = shopType;
		this.shopAddress = shopAddress;
		this.sUsername = sUsername;
		this.sPwd = sPwd;
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

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
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
	
	
}
