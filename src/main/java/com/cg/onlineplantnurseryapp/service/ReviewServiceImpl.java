package com.cg.onlineplantnurseryapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.onlineplantnurseryapp.entity.Review;
import com.cg.onlineplantnurseryapp.exception.*;
import com.cg.onlineplantnurseryapp.repository.ReviewRepository;
@Service
public class ReviewServiceImpl implements IReviewService{
	 @Autowired
 private ReviewRepository reviewRepository;
	 @Override
	public Review saveReview(Review review) {
		 return reviewRepository.save(review);
	}
	 @Override
	public List<Review> getAllReviews() {
		 return reviewRepository.findAll();
	}
	 @Override
	public ResponseEntity<Review> updateReview(Long reviewId, Review reviewDetails) throws ResourceNotFoundException {
		Review review = reviewRepository.findById(reviewId)
				 .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + reviewId));
		 review.setCustomerId(reviewDetails.getCustomerId());
		 review.setOrderId(reviewDetails.getOrderId());
		 review.setOrderReview(reviewDetails.getOrderReview());
		 review.setOrderRating(reviewDetails.getOrderRating());
		 final Review updatedReview = reviewRepository.save(review);
		 return ResponseEntity.ok(updatedReview);
	}
	 @Override
	public ResponseEntity<?> deleteReview(Long reviewId) throws ResourceNotFoundException {
		 return reviewRepository.findById(reviewId).map(review -> {
			 reviewRepository.delete(review);
			 return ResponseEntity.ok().build();
			 }).orElseThrow(()->new ResourceNotFoundException("review not found"));
	}
	 @Override
	public ResponseEntity<Review> getReviewById(Long reviewId) throws ResourceNotFoundException {
		Review review = reviewRepository.findById(reviewId)
				 .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + reviewId));
		 return ResponseEntity.ok().body(review);
	 }
	
}
