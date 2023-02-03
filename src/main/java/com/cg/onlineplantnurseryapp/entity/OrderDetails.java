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
@Table(name="order_details")
public class OrderDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailsId;
	
	@Column(name = "plant_id")
	private Long plantId;
	
	@Column(name = "plant_name", nullable = false)
	private String plantName;
	
	@Column(name = "plant_price", nullable = false)
	private double plantPrice;
	
	@Column(name = "seed_id")
	private Long seedId;
	
	@Column(name = "seed_name", nullable = false)
	private String seedName;
	
	@Column(name = "seed_price", nullable = false)
	private double seedPrice;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "admin_id")
	private Long adminId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderDetails() {
		super();
	}

	public OrderDetails(Long plantId, String plantName, double plantPrice,Long seedId, String seedName, double seedPrice, long quantity, double totalPrice, Long adminId,
			String status, String comments) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantPrice = plantPrice;
		this.seedId = seedId;
		this.seedName = seedName;
		this.seedPrice = seedPrice;
		this.quantity=quantity;
		this.totalPrice=totalPrice;
		this.adminId=adminId;
		this.status=status;
		this.comments = comments;
	}

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
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

	public Long getAdminId() {
		return adminId;
	}


	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}


	public Long getOrderDetailsId() {
		return orderDetailsId;
	}


	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getSeedId() {
		return seedId;
	}

	public void setSeedId(Long seedId) {
		this.seedId = seedId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", plantId=" + plantId + ", plantName=" + plantName
				+ ", plantPrice=" + plantPrice + ", seedId=" + seedId + ", seedName=" + seedName
				+ ", plantPrice=" + seedPrice +", quantity=" + quantity + ", totalPrice=" + totalPrice + ", vendorId="
				+ adminId + ", status=" + status + ", comments=" + comments + ", order=" + order + "]";
	}

	
	
	
	
	

}
