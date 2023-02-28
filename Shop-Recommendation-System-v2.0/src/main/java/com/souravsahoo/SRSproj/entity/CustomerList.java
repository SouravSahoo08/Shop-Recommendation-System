package com.souravsahoo.SRSproj.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "customer_list")
public class CustomerList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_no")
	private int slNo;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String customerName;

	@Column(name = "age")
	private int age;

	@Column(name = "phone")
	private int phoneNo;

	@Column(name = "address")
	private String userAddress;

	@Column(name = "username")
	private String cUsername;

	@Column(name = "pwd")
	private String cPwd;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public CustomerList() {

	}

	public CustomerList(int slNo, String userId, String customerName, int age, int phoneNo, String userAddress,
			String uUsername, String uPwd, Collection<Role> roles) {
		super();
		this.slNo = slNo;
		this.userId = userId;
		this.customerName = customerName;
		this.age = age;
		this.phoneNo = phoneNo;
		this.userAddress = userAddress;
		this.cUsername = uUsername;
		this.cPwd = uPwd;
		this.roles = roles;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getcUsername() {
		return cUsername;
	}

	public void setcUsername(String cUsername) {
		this.cUsername = cUsername;
	}

	public String getcPwd() {
		return cPwd;
	}

	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "CustomerList [slNo=" + slNo + ", userId=" + userId + ", customerName=" + customerName + ", age=" + age + ", phoneNo="
				+ phoneNo + ", userAddress=" + userAddress + ", uUsername=" + cUsername + ", uPwd=" + cPwd + ", roles="
				+ roles + "]";
	}

}
