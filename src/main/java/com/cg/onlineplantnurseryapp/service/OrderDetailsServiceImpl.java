package com.cg.onlineplantnurseryapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.onlineplantnurseryapp.entity.OrderDetails;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;
import com.cg.onlineplantnurseryapp.repository.OrderDetailsRepository;
import com.cg.onlineplantnurseryapp.repository.OrderRepository;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDetails orderDetails(String orderId, OrderDetails orderDetails) throws ResourceNotFoundException {
		return orderRepository.findById(orderId).map(order -> {
			orderDetails.setOrder(order);
			return orderDetailsRepository.save(orderDetails);
		}).orElseThrow(() -> new ResourceNotFoundException("order not found"));
	}

	@Override
	public List<OrderDetails> getAllOrderDetailsByOrderId(String orderId) {
		return orderDetailsRepository.findByOrder_OrderId(orderId);
	}

	@Override
	public ResponseEntity<?> deleteOrderDetails(String orderId) throws ResourceNotFoundException {
		List<OrderDetails> orderDetails = orderDetailsRepository.findByOrder_OrderId(orderId);
		for (OrderDetails oD : orderDetails){
			orderDetailsRepository.delete(oD);
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public List<OrderDetails> getOrderDetailsByAdminId(Long adminId) {
		return orderDetailsRepository.findByAdminId(adminId);
	}

	@Override
	public ResponseEntity<OrderDetails> updateAdmin(Long orderDetailsId, OrderDetails orderDetails)
			throws ResourceNotFoundException {
		 OrderDetails newOrderDetails = orderDetailsRepository.findById(orderDetailsId)
			        .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + orderDetailsId));

			        newOrderDetails.setStatus(orderDetails.getStatus());
			        newOrderDetails.setComments(orderDetails.getComments());
			        
			        final OrderDetails updatedOrerDetails = orderDetailsRepository.save(newOrderDetails);
			        return ResponseEntity.ok(updatedOrerDetails);
	}

}

