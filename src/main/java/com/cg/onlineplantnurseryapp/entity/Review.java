package com.cg.onlineplantnurseryapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "reviews")
public class Review{
	@Id 
	@Column(name="review_id")
	private Long reviewId;
	
	@Column(name = "custId")
	private Long customerId;
	
	@Column(name = "order_Id")
	private Long orderId;
	
	@Column(name = "order_rating")
	private Long orderRating;
	
	@Column(name = "order_review")
	private String orderReview;
	public Review() {
		super();
	}	
	public Review(Long customerId, Long orderId, Long orderRating, String orderReview) {
			super();
	 this.customerId = customerId;
	 this.orderId = orderId;
	 this.orderRating = orderRating;
	 this.orderReview = orderReview;
	}
	public Long getReviewId() {
		 return reviewId;
	}
	 public void setReviewId(Long reviewId) {
		 this.reviewId = reviewId;
	}
	 public Long getCustomerId() {
		 return customerId;
	}
	 public void setCustomerId(Long customerId) {
		 this.customerId = customerId;
	}
	 public Long getOrderId() {
		return orderId;
	}
	 public void setOrderId(Long orderId) {
		 this.orderId = orderId;
	 }
	 public Long getOrderRating() {
		 return orderRating;
	 }
	 public void setOrderRating(Long orderRating) {
		 this.orderRating = orderRating;
	 }
	 public String getOrderReview() {
		 return orderReview;
	 }
	 public void setOrderReview(String orderReview) {
		 this.orderReview = orderReview;
	 }
	 @Override
	 public String toString() {
		 return "Feedback [feedbackId=" + reviewId + ", customerId=" + customerId + ", orderId=" + orderId + ", orderDetails=" + orderRating + ", orderFeedback=" + orderReview +"]";
	 }


}
