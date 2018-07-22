package com.iansky.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pId;
	private String pName;
	private String pCategory;
	private String pDescription;
	private double pPrice;
	private String pCondition;
	private String pStatus;
	private int pUnitInStock;
	private String pManufacturer;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public String getpCondition() {
		return pCondition;
	}

	public void setpCondition(String pCondition) {
		this.pCondition = pCondition;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public int getpUnitInStock() {
		return pUnitInStock;
	}

	public void setpUnitInStock(int pUnitInStock) {
		this.pUnitInStock = pUnitInStock;
	}

	public String getpManufacturer() {
		return pManufacturer;
	}

	public void setpManufacturer(String pManufacturer) {
		this.pManufacturer = pManufacturer;
	}
}
