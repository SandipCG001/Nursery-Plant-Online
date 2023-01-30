package com.cg.onlineplantnurseryapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineplantnurseryapp.entity.Order;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;

public interface IOrderService {
	public Order saveOrder(Order order);
	public List<Order> getAllOrders();
	public ResponseEntity<Order> updateOrder(String orderId,Order orderDetails) throws ResourceNotFoundException;
	public ResponseEntity<?> deleteOrder(String orderId) throws ResourceNotFoundException;
	public ResponseEntity<Order> getOrderById(String orderId)throws ResourceNotFoundException;

}

