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
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "phone")
	private int phoneNo;

	@Column(name = "address")
	private String userAddress;

	@Column(name = "username")
	private String uUsername;

	@Column(name = "pwd")
	private String uPwd;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public CustomerList() {

	}

	public CustomerList(int slNo, String userId, String name, int age, int phoneNo, String userAddress,
			String uUsername, String uPwd) {
		super();
		this.slNo = slNo;
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.phoneNo = phoneNo;
		this.userAddress = userAddress;
		this.uUsername = uUsername;
		this.uPwd = uPwd;
	}

	public CustomerList(int slNo, String userId, String name, int age, int phoneNo, String userAddress,
			String uUsername, String uPwd, Collection<Role> roles) {
		super();
		this.slNo = slNo;
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.phoneNo = phoneNo;
		this.userAddress = userAddress;
		this.uUsername = uUsername;
		this.uPwd = uPwd;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getuUsername() {
		return uUsername;
	}

	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "CustomerList [slNo=" + slNo + ", userId=" + userId + ", name=" + name + ", age=" + age + ", phoneNo="
				+ phoneNo + ", userAddress=" + userAddress + ", uUsername=" + uUsername + ", uPwd=" + uPwd + ", roles="
				+ roles + "]";
	}

}
