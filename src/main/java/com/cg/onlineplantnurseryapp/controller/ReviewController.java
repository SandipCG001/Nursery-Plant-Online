package com.cg.onlineplantnurseryapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineplantnurseryapp.entity.Review;
import com.cg.onlineplantnurseryapp.exception.*;
import com.cg.onlineplantnurseryapp.service.IReviewService;
@RestController@RequestMapping("/api/f1")
public class ReviewController {
	 @Autowired
	private IReviewService reviewService;
	 //save an order
	@PostMapping("/reviews")
	 public Review reviewOrder(@Valid @RequestBody Review review)
	 {
return reviewService.saveReview(review);
}
	//get all orders
	@GetMapping("/reviews")
	 public List<Review> getAllReviews()
	 {
		return reviewService.getAllReviews();
}
 //update orders 
 @PutMapping("/reviews/{id}")
	 public ResponseEntity<Review> updateReview(@PathVariable(value = "id") Long reviewId,
			@Valid @RequestBody Review reviewDetails) throws ResourceNotFoundException {
		 return reviewService.updateReview(reviewId, reviewDetails);
		}
	//delete order
	@DeleteMapping("/reviews/{reviewId}")
	 public ResponseEntity<?> deleteReview(
			 @PathVariable(value = "reviewId") Long reviewId)
	 throws ResourceNotFoundException
 {
		return reviewService.deleteReview(reviewId);
 }
//get order by orderId
	@GetMapping("/reviews/{id}")
	 public ResponseEntity<Review> getReviewById(@PathVariable(value = "id") Long reviewId)
	 throws ResourceNotFoundException {
		 return reviewService.getReviewById(reviewId);
	}
	}
