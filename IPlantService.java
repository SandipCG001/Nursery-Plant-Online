package com.cg.onlineplantnurseryapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineplantnurseryapp.entity.Plant;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;


public interface IPlantService {
	public List<Plant> getPlantByAdminId(Long adminId);

	public List<Plant> getPlant();

	public Plant savePlantByAdminId(Long adminId, Plant Plant) throws ResourceNotFoundException;

	public Plant createPlant(Plant Plant);

	public ResponseEntity<Plant> getPlantById(Long PlantId) throws ResourceNotFoundException;

	public ResponseEntity<Plant> updatePlant(Long PlantId, Plant PlantDetails) throws ResourceNotFoundException;

	public ResponseEntity<?> deletePlant(Long adminId, Long PlantId) throws ResourceNotFoundException;
}
