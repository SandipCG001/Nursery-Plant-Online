package com.cg.onlineplantnurseryapp.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlineplantnurseryapp.entity.Customer;
import com.cg.onlineplantnurseryapp.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class CustomerControllerTest {
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
	private Customer customer;
//	private Customer Customer1;
	
	@BeforeEach
	public void init() {
		customer = new Customer("ABC", "abc@gmail.com","abc", "123abc");
//		Customer1 = new Customer("customer","customer@gmail.com,"cust "123Customer");
	
	}
	
	@Test
	public void testAddCustomer() throws Exception{
		when(customerService.createCustomer((Customer) any(Customer.class))).thenReturn(customer);
	}
	
	@Test
	public void testGetCustomerList() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(customer);
		when(customerService.getCustomerList()).thenReturn(customerList);
	}

}