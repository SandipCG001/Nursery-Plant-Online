package com.cg.onlineplantnurseryapp.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.*;

import com.cg.onlineplantnurseryapp.entity.Admin;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;

import com.cg.onlineplantnurseryapp.service.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class AdminControllerTest {
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
	
	private Admin admin;

	@BeforeEach
	public void init() {
		admin = new Admin(2L,"Pranav","Pranav@cg.com", "pranav123");

	}
	
	@Test
	public void testAddAdmin() throws Exception{
		when(adminService.createAdmin((Admin) any(Admin.class))).thenReturn(admin);
	}
	
	@Test
	public void testlistAllAdmin() {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList.add(admin);
//		adminList.add(admin1);
		when(adminService.getAllAdmins()).thenReturn(adminList);
	}
	
//	@Test
//	public void testgetAdminById() throws ResourceNotFoundException {	
//		when(adminService.getAdminById(anyLong())).thenReturn(admin);
//	}

}
