package com.cg.onlineplantnurseryapp.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineplantnurseryapp.entity.OrderDetails;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;



public interface IOrderDetailsService {
	public OrderDetails orderDetails(String orderId,OrderDetails orderDetails) throws ResourceNotFoundException;
	public List<OrderDetails> getAllOrderDetailsByOrderId(String orderId);
    public ResponseEntity<?> deleteImage(String orderId) throws ResourceNotFoundException;
	public List<OrderDetails> getOrderDetailsByVendorId(Long vendorId);
	   public ResponseEntity<OrderDetails> updateVendor(Long orderDetailsId,
		         OrderDetails orderDetails) throws ResourceNotFoundException ;
}

