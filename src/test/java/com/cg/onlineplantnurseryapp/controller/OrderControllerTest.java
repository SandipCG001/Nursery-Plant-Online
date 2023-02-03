package com.cg.onlineplantnurseryapp.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.*;

import com.cg.onlineplantnurseryapp.entity.Order;
import com.cg.onlineplantnurseryapp.entity.Seed;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;

import com.cg.onlineplantnurseryapp.service.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IAdminService adminService;
	
	@MockBean
	private ICustomerService customerService;
	
	@MockBean
	private IOrderService orderService;
	
	@MockBean
	private IOrderDetailsService orderDetailsService;
	
	@MockBean
	private IPlantService plantService;
	
	@MockBean
	private ISeedService seedService;	
	
	@MockBean
	private IReviewService reviewService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Order order;
//	private ResponseEntity<Order> order1;
	Date date = new Date();
	@BeforeEach
	public void init() {
		order = new Order("2",23L,345, "Placed",date);
		//order1 = new Order("2",23L,345, "Placed",date);
	
	}
	
	@Test
	public void testgetOrderById() throws Exception{
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
//		adminList.add(admin1);
		when(orderService.getAllOrders()).thenReturn(orderList);
	}
//	@Test
//	public void testgetOrderById() throws ResourceNotFoundException {	
//		when(orderService.getOrderById(anyString())).thenReturn(order1);
//	}

}
