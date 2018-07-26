package com.iansky.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pId;

	@NotEmpty(message = "Product Name must not be null")
	private String pName;
	private String pCategory;
	private String pDescription;

	@Min(value = 0, message = "Product price must not be less than 0")
	private double pPrice;
	private String pCondition;
	private String pStatus;

	@Min(value = 0, message = "Unit in Stock must not be less than 0")
	private int pUnitInStock;
	private String pManufacturer;

	@Transient
	private MultipartFile pImage;

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

	public MultipartFile getpImage() {
		return pImage;
	}

	public void setpImage(MultipartFile pImage) {
		this.pImage = pImage;
	}
}
