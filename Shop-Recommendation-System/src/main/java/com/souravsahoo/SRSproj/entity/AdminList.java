package com.souravsahoo.SRSproj.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "admin_list")
public class AdminList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_no")
	private int slNo;

	@Column(name = "admin_name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "phone")
	private int phoneNo;

	@Column(name = "address")
	private String adminAddress;

	@Column(name = "username")
	private String aUsername;

	@Column(name = "pwd")
	private String aPwd;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public AdminList() {

	}

	public AdminList(int slNo, String name, int age, int phoneNo, String adminAddress, String aUsername, String aPwd,
			Collection<Role> roles) {
		super();
		this.slNo = slNo;
		this.name = name;
		this.age = age;
		this.phoneNo = phoneNo;
		this.adminAddress = adminAddress;
		this.aUsername = aUsername;
		this.aPwd = aPwd;
		this.roles = roles;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
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

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getaUsername() {
		return aUsername;
	}

	public void setaUsername(String aUsername) {
		this.aUsername = aUsername;
	}

	public String getaPwd() {
		return aPwd;
	}

	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "AdminList [slNo=" + slNo + ", name=" + name + ", age=" + age + ", phoneNo=" + phoneNo
				+ ", adminAddress=" + adminAddress + ", aUsername=" + aUsername + ", aPwd=" + aPwd + ", roles=" + roles
				+ "]";
	}

}
