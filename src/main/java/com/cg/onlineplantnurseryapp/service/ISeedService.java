package com.cg.onlineplantnurseryapp.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineplantnurseryapp.entity.Seed;
import com.cg.onlineplantnurseryapp.exception.*;

public interface ISeedService {
	public List<Seed> getSeedByAdminId(Long adminId);

	public List<Seed> getSeed();

	public Seed saveSeedByAdminId(Long adminId, Seed seed) throws ResourceNotFoundException;

	public Seed createSeed(Seed seed);

	public ResponseEntity<Seed> getSeedById(Long seedId) throws ResourceNotFoundException;

	public ResponseEntity<Seed> updateSeed(Long seedId, Seed seedDetails) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteSeed(Long adminId, Long seedId) throws ResourceNotFoundException;
}