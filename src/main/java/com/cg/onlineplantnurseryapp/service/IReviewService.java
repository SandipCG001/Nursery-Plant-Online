package com.cg.onlineplantnurseryapp.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.cg.onlineplantnurseryapp.entity.Review;
import com.cg.onlineplantnurseryapp.exception.*;
public interface IReviewService {
	 public Review saveReview(Review review);
	 public List<Review> getAllReviews();
	 public ResponseEntity<Review> updateReview(Long reviewId,Review reviewDetails) throws ResourceNotFoundException;
	 public ResponseEntity<?> deleteReview(Long reviewId) throws ResourceNotFoundException;
	 public ResponseEntity<Review> getReviewById(Long reviewId)throws ResourceNotFoundException;
	
}