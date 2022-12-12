package com.souravsahoo.SRSproj.entity;

import javax.persistence.*;

@Entity
@Table(name = "owner_list")
public class OwnerList {

	@Id
	@Column(name = "sl_no")
	private int slNo;

	@Column(name = "owner_id")
	private String ownerId;

	public OwnerList() {

	}

	public OwnerList(int slNo, String ownerId) {
		super();
		this.slNo = slNo;
		this.ownerId = ownerId;
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

	@Override
	public String toString() {
		return "OwnerList [slNo=" + slNo + ", ownerId=" + ownerId + "]";
	}

}
