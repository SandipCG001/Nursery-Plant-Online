package com.cg.onlineplantnurseryapp.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnurseryapp.entity.OrderDetails;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;
import com.cg.onlineplantnurseryapp.service.IOrderDetailsService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class OrderDetailsController {
	
	@Autowired
	private IOrderDetailsService orderDetailsService;
	
	//save order details with corresponded orderId
	@PostMapping("/orders/{orderId}/orderdetails")
	public OrderDetails orderDetails(@PathVariable(value="orderId") String orderId,
			@Valid @RequestBody OrderDetails orderDetails) throws ResourceNotFoundException
	{
		return orderDetailsService.orderDetails(orderId, orderDetails);
	}
	
	//get all the order details by corresponding orderId
	@GetMapping("/orders/{orderId}/orderdetails")
	public List<OrderDetails> getAllOrderDetailsByOrderId(@PathVariable(value="orderId") String orderId)
	{
		return orderDetailsService.getAllOrderDetailsByOrderId(orderId);
	}
	
	//delete order details by corresponding orderId
	@DeleteMapping("/orders/{orderId}/orderdetails")
    public ResponseEntity<?> deleteImage(@PathVariable(value = "orderId") String orderId)
	   throws ResourceNotFoundException {
		return orderDetailsService.deleteImage(orderId);
	}
	
	//get orderDetails by vendorId
	@GetMapping("/orders/vendorid={vendorId}/orderdetails")
	public List<OrderDetails> getOrderDetailsByVendorId(@PathVariable(value = "vendorId") Long vendorId)
	{
		return orderDetailsService.getOrderDetailsByVendorId(vendorId);
	}
	
	//update orderDetails by orderId and orderDetailsId
	@PutMapping("/orders/orderdetails/{orderDetailsId}")
    public ResponseEntity<OrderDetails> updateVendor(@PathVariable(value = "orderDetailsId") Long orderDetailsId,
         @Valid @RequestBody OrderDetails orderDetails) throws ResourceNotFoundException {
		return orderDetailsService.updateVendor(orderDetailsId, orderDetails);
    }

}

