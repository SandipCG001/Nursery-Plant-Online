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
import com.cg.onlineplantnurseryapp.entity.Plant;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;

import com.cg.onlineplantnurseryapp.service.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class PlantControllerTest {
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
	private Plant plant;
//	private Plant plant1;
	
	@BeforeEach
	public void init() {
		plant = new Plant("Ficus", 2000, "10 years old Bonsai.");
//		plant1 = new Plant("Orange", 1000, "Seed-less orange that grows 4ft tall.");

	}
	
	@Test
	public void testAddPlant() throws Exception{
		when(plantService.createPlant((Plant) any(Plant.class))).thenReturn(plant);
	}
	
	@Test
	public void testlistAllPlant() {
		List<Plant> plantList = new ArrayList<Plant>();
		plantList.add(plant);
		when(plantService.getPlant()).thenReturn(plantList);
	}
	

}
