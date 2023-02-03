package com.cg.onlineplantnurseryapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.onlineplantnurseryapp.entity.Customer;

@Entity
@Table(name = "plant")
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plant_id")
	private long plantId;
	
	@Column(name = "plant_name", nullable = false)
	private String plantName;
	
	@Column(name = "plant_price", nullable = false)
	private double plantPrice;
	
	@Column(name = "plant_description")
	private String description;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	public Plant() {
		super();
	}


	public Plant(String plantName, double plantPrice, String description) {
		super();
		this.plantName = plantName;
		this.plantPrice = plantPrice;
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

	public long getPlantId() {
		return plantId;
	}

	public void setPlantId(long plantId) {
		this.plantId = plantId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public double getPlantPrice() {
		return plantPrice;
	}

	public void setPlantPrice(double plantPrice) {
		this.plantPrice = plantPrice;
	}


	@Override
	public String toString() {
		return "Plant[plantId=" + plantId + ", plantName=" + plantName + ", plantPrice=" + plantPrice + ", description="
				+ description + ", admin=" + admin + "]";
	}
}
