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

import com.cg.onlineplantnurseryapp.entity.Seed;
import com.cg.onlineplantnurseryapp.exception.*;
import com.cg.onlineplantnurseryapp.service.ISeedService;


@RestController 
@RequestMapping("/api/v1")
public class SeedController {
	@Autowired
	private ISeedService seedService;
	
	//get seed for corresponding admin
	@GetMapping("/admin/{adminId}/seed")
	public List<Seed> getSeedByAdminId(@PathVariable(value = "adminId") Long adminId)
	{
		return seedService.getSeedByAdminId(adminId);
		
	}
	
	//Get allseeds to create a seed
	@GetMapping("/seed")
	public List<Seed> getSeed()
	{
		return seedService.getSeed();
	}
	
	//Add a new seed for corresponding admin
	@PostMapping("/admin/{adminId}/seed")
	public Seed saveSeedByAdminId(@PathVariable(value = "adminId") Long adminId, 
			@Valid @RequestBody Seed seed) throws ResourceNotFoundException
	{
		return seedService.saveSeedByAdminId(adminId, seed);
	}
	
	//Add a new seed in seed
	@PostMapping("/seed")
	public Seed createSeed(@Valid @RequestBody Seed seed)
	{
		return seedService.createSeed(seed);
		
	}
	
	
	@GetMapping("/seeds/{seedId}")
    public ResponseEntity<Seed> getSeedById(@PathVariable(value = "seedId") Long seedId)
        throws ResourceNotFoundException {
		return seedService.getSeedById(seedId);
    }
	
	
	@PutMapping("/seed/{seedId}")
    public ResponseEntity<Seed> updateSeed(@PathVariable(value = "seedId") Long seedId,
         @Valid @RequestBody Seed seedDetails) throws ResourceNotFoundException
	{
		return seedService.updateSeed(seedId, seedDetails);
    }
	
	//Delete an seed according to seedId and adminId
	@DeleteMapping("/admin/{adminId}/seed/{seedId}")
	public ResponseEntity<?> deleteSeed(@PathVariable(value = "adminId") Long adminId,
	           @PathVariable(value = "seedId") Long seedId)
		
	throws ResourceNotFoundException
	{
		return seedService.deleteSeed(adminId, seedId);
	}
	
	
	
}
