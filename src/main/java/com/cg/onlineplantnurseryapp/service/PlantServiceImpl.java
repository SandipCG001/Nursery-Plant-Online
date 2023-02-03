package com.cg.onlineplantnurseryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnurseryapp.entity.Plant;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;
import com.cg.onlineplantnurseryapp.repository.AdminRepository;
import com.cg.onlineplantnurseryapp.repository.PlantRepository;



@Service
public class PlantServiceImpl implements IPlantService {
    
	@Autowired 
     private PlantRepository plantRepository;
	
	
	@Autowired
	 private AdminRepository adminRepository;

	@Override
	public List<Plant> getPlantByAdminId(Long adminId) {
		return plantRepository.findByAdmin_AdminId(adminId);
	}

	@Override
	public List<Plant> getPlant() {
		return plantRepository.findAll();
	}

	@Override
	public ResponseEntity<Plant> getPlantById(Long PlantId) throws ResourceNotFoundException {
		 Plant Plant = plantRepository.findById(PlantId)
		          .orElseThrow(() -> new ResourceNotFoundException("Plant not found for this id :: " + PlantId));
		        return ResponseEntity.ok().body(Plant);
	}

	@Override
	public ResponseEntity<Plant> updatePlant(Long PlantId, Plant plantDetails) throws ResourceNotFoundException {
		Plant Plant = plantRepository.findById(PlantId)
		        .orElseThrow(() -> new ResourceNotFoundException("Plant not found for this id :: " + PlantId));

		       Plant.setPlantName(plantDetails.getPlantName());
		        Plant.setPlantPrice(plantDetails.getPlantPrice());
		        Plant.setDescription(plantDetails.getDescription());  
		        
		        final Plant updatedPlant = plantRepository.save(Plant);
		        return ResponseEntity.ok(updatedPlant);
	}

	@Override
	public ResponseEntity<?> deletePlant(Long adminId, Long PlantId) throws ResourceNotFoundException {
		return plantRepository.findByPlantIdAndAdmin_AdminId(PlantId, adminId).map(Plant -> {
			plantRepository.delete(Plant);
		return ResponseEntity.ok().build();
		}).orElseThrow(()->new ResourceNotFoundException("Plant not found"));
	}


	@Override
	public Plant createPlant(Plant plant) {
		// TODO Auto-generated method stub
		return plantRepository.save(plant);
	}

	@Override
	public Plant savePlantByAdminId(Long adminId, Plant plant) throws ResourceNotFoundException {
		return adminRepository.findById(adminId).map(admin ->{
			plant.setAdmin(admin);
			return plantRepository.save(plant);
		}).orElseThrow(() -> new ResourceNotFoundException("plant not found"));
	}

	
}