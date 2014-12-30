package com.mediaocean.marketknowledge.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="sales_entry")
public class SalesEntry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5656423165457405353L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long salesId;
	
	@Column(name="dateofsale")
	private Date dateOfSale;
	
	
	//type of sale amount can be a user defined type like Money, here double is just for assignment purpose.
	@Column(name="saleamount")
	private Double saleAmount;
	
	@Version
	private long version;
	
	@ManyToOne
	private Product product;

	public long getSalesId() {
		return salesId;
	}

	public void setSalesId(long salesId) {
		this.salesId = salesId;
	}

	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public Double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
