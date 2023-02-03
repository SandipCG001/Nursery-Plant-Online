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

import com.cg.onlineplantnurseryapp.entity.Seed;
import com.cg.onlineplantnurseryapp.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class SeedControllerTest{
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
	private Seed seed;
//	private Seed seed1;
	
	@BeforeEach
	public void init() {
		seed = new Seed("Mango", 80, "seed");
//		seed1 = new Seed("pumpkin", 150, "seed");
	
	}
	
	@Test
	public void testAddSeed() throws Exception{
		when(seedService.createSeed((Seed) any(Seed.class))).thenReturn(seed);
	}
	
	@Test
	public void testlistAllSeed() {
		List<Seed> seedList = new ArrayList<Seed>();
		seedList.add(seed);
//		adminList.add(admin1);
		when(seedService.getSeed()).thenReturn(seedList);
	}
	
}