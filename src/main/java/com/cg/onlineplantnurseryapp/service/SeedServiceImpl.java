package com.cg.onlineplantnurseryapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnurseryapp.entity.Seed;
import com.cg.onlineplantnurseryapp.exception.*;
import com.cg.onlineplantnurseryapp.repository.AdminRepository;
import com.cg.onlineplantnurseryapp.repository.SeedRepository;


@Service
public class SeedServiceImpl implements ISeedService {
    
	@Autowired 
     private SeedRepository seedRepository;
	
	@Autowired
	 private AdminRepository adminRepository;

	@Override
	public List<Seed> getSeedByAdminId(Long adminId) {
		return seedRepository.findByAdmin_AdminId(adminId);
	}

	@Override
	public List<Seed> getSeed() {
		return seedRepository.findAll();
	}
	
	@Override
	public Seed saveSeedByAdminId(Long adminId, Seed seed) throws ResourceNotFoundException {
		return adminRepository.findById(adminId).map(admin ->{
			seed.setAdmin(admin);
			return seedRepository.save(seed);
		}).orElseThrow(() -> new ResourceNotFoundException("admin not found"));
	}

	@Override
	public Seed createSeed(Seed seed) {
		return seedRepository.save(seed);
	}

	@Override
	public ResponseEntity<Seed> getSeedById(Long seedId) throws ResourceNotFoundException {
		 Seed seed = seedRepository.findById(seedId)
		          .orElseThrow(() -> new ResourceNotFoundException("Seed not found for this id :: " + seedId));
		        return ResponseEntity.ok().body(seed);
	}

	@Override
	public ResponseEntity<Seed> updateSeed(Long seedId, Seed seedDetails) throws ResourceNotFoundException {
		Seed seed = seedRepository.findById(seedId)
		        .orElseThrow(() -> new ResourceNotFoundException("Seed not found for this id :: " + seedId));

		       seed.setSeedName(seedDetails.getSeedName());
		        seed.setSeedPrice(seedDetails.getSeedPrice());
		        seed.setDescription(seedDetails.getDescription());  
		        
		        final Seed updatedSeed = seedRepository.save(seed);
		        return ResponseEntity.ok(updatedSeed);
	}

	@Override
	public ResponseEntity<?> deleteSeed(Long adminId, Long seedId) throws ResourceNotFoundException {
		return seedRepository.findBySeedIdAndAdmin_AdminId(seedId, adminId).map(seed -> {
			seedRepository.delete(seed);
		return ResponseEntity.ok().build();
		}).orElseThrow(()->new ResourceNotFoundException("seed not found"));
	}

}
     
