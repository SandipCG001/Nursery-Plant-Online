package com.cg.onlineplantnurseryapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custid", nullable = false)
	private Long customerId;
	
	@Column(name="cust_name", nullable = false)
	private String custName;
	
	
	@Column(name = "email", nullable = false)
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "cust_password", nullable = false)
	private String custPassword;
	
	@Column(name = "cust_mobile_number", nullable = false)
	@Pattern(regexp="(^$|[0-9]{10})")
	private double custmobileNumber;
	
	@Column(name = "order_id")
	private long orderId;

	public Customer() {
		super();
	}
	
	

	public Customer(String custName, String email, String username, String custPassword) {
		super();
		this.custName = custName;
		this.email = email;
		this.username = username;
		this.custPassword = custPassword;
		this.custmobileNumber = 0;
		this.orderId = 0;
	}



	public Customer(String custName, String email, String username, String custPassword, int custmobileNumber, long orderId) {
		super();
		this.custName = custName;
		this.email = email;
		this.username = username;
		this.custPassword = custPassword;
		this.custmobileNumber = custmobileNumber;
		this.orderId = orderId;
	}


	

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getName() {
		return custName;
	}

	public void setName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return custPassword;
	}

	public void setPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public double getMobileNumber() {
		return custmobileNumber;
	}

	public void setMobileNumber(double custmobileNumber) {
		this.custmobileNumber = custmobileNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + custName + ", email="+email
				+ ", orderId=" + orderId + "]";
	}
	
	
}
