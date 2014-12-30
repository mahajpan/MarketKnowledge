package com.mediaocean.marketknowledge.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.MERGE;

@Entity
@Table(name="product_table")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424919785823278446L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	
	@Column(name="product_name")
	private String productName;
	
	@Version
	private long version;
	
	@OneToMany(fetch=FetchType.LAZY, cascade={PERSIST,REMOVE,MERGE},mappedBy="product")
	private List<SalesEntry> saleEntries = new ArrayList<SalesEntry>();

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public List<SalesEntry> getSaleEntries() {
		return saleEntries;
	}

	public void setSaleEntries(List<SalesEntry> saleEntries) {
		this.saleEntries = saleEntries;
	}
	
	
}
