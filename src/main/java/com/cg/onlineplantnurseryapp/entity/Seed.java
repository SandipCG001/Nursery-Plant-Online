package com.cg.onlineplantnurseryapp.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seed")
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seed_id")
	private long seedId;
	
	@Column(name = "seed_name", nullable = false)
	private String seedName;
	
	@Column(name = "seed_price", nullable = false)
	private double seedPrice;
	
	@Column(name = "seed_description")
	private String description;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	public Seed() {
		super();
	}


	public Seed(String seedName, double seedPrice, String description) {
		super();
		this.seedName = seedName;
		this.seedPrice = seedPrice;
		this.description = description;
	}


	public String getDescription() {
		return description;
	}


	
	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public long getSeedId() {
		return seedId;
	}

	public void setSeedId(long seedId) {
		this.seedId = seedId;
	}

	public String getSeedName() {
		return seedName;
	}

	public void setSeedName(String seedName) {
		this.seedName = seedName;
	}

	public double getSeedPrice() {
		return seedPrice;
	}

	public void setSeedPrice(double seedPrice) {
		this.seedPrice = seedPrice;
	}



	@Override
	public String toString() {
		return "Seed[seedId=" + seedId + ", seedName=" + seedName + ", seedPrice=" + seedPrice + ", description="
				+ description + ", admin=" + admin+ "]";
	}





}