package com.ums.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sale_product")
public class SaleProduct {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "sale_product_id")
	private UUID saleProductId;

	// private Long id;
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "name")
	private String name;

	@Column(name = "brand")
	private String brand;

	@Column(name = "inch")
	private Integer inch;
	
	@Column(name = "product_match")
	private String productMatch;

	@Column(name = "madein")
	private String madein;

	@Column(name = "product_price")
	private float productPrice;

	@Column(name = "saled_price")
	private float saledPrice;

	@Column(name = "saled_date")
	private Date saledDate;


	public UUID getSaleProductId() {
		return saleProductId;
	}

	public void setSaleProductId(UUID saleProductId) {
		this.saleProductId = saleProductId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getInch() {
		return inch;
	}

	public void setInch(Integer inch) {
		this.inch = inch;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}


	public float getSaledPrice() {
		return saledPrice;
	}

	public void setSaledPrice(float saledPrice) {
		this.saledPrice = saledPrice;
	}

	public Date getSaledDate() {
		return saledDate;
	}

	public void setSaledDate(Date saledDate) {
		this.saledDate = saledDate;
	}

	public String getProductMatch() {
		return productMatch;
	}

	public void setProductMatch(String productMatch) {
		this.productMatch = productMatch;
	}


}
