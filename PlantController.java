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

import com.cg.onlineplantnurseryapp.entity.Plant;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;
import com.cg.onlineplantnurseryapp.service.IPlantService;




@RestController 
@RequestMapping("/api/v1")
public class PlantController {
	@Autowired
	private IPlantService plantService;
	
	//get Plant for corresponding admin
	@GetMapping("/admin/{adminId}/Plant")
	public List<Plant> getPlantByAdminId(@PathVariable(value = "adminId") Long adminId)
	{
		return plantService.getPlantByAdminId(adminId);
		
	}
	
	//Get Plants 
	@GetMapping("/Plant")
	public List<Plant> getPlant()
	{
		return plantService.getPlant();
	}
	
	//Add a new Plant for corresponding admin
	@PostMapping("/admin/{adminId}/Plant")
	public Plant savePlantByAdminId(@PathVariable(value = "adminId") Long adminId, 
			@Valid @RequestBody Plant Plant) throws ResourceNotFoundException
	{
		return plantService.savePlantByAdminId(adminId, Plant);
	}
	
	//Add a new Plant in Plant
	@PostMapping("/Plant")
	public Plant createPlant(@Valid @RequestBody Plant plant)
	{
		return plantService.createPlant(plant);
		
	}
	
	
	@GetMapping("/Plants/{PlantId}")
    public ResponseEntity<Plant> getPlantById(@PathVariable(value = "PlantId") Long PlantId)
        throws ResourceNotFoundException {
		return plantService.getPlantById(PlantId);
    }
	
	
	@PutMapping("/Plant/{PlantId}")
    public ResponseEntity<Plant> updatePlant(@PathVariable(value = "PlantId") Long PlantId,
         @Valid @RequestBody Plant PlantDetails) throws ResourceNotFoundException
	{
		return plantService.updatePlant(PlantId, PlantDetails);
    }
	
	//Delete an Plant according to PlantId and adminId
	@DeleteMapping("/admin/{adminId}/Plant/{PlantId}")
	public ResponseEntity<?> deletePlant(@PathVariable(value = "adminId") Long adminId,
	           @PathVariable(value = "PlantId") Long PlantId)
		
	throws ResourceNotFoundException
	{
		return plantService.deletePlant(adminId, PlantId);
	}
}

