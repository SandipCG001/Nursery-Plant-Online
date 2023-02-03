package com.cg.onlineplantnurseryapp.repository;


import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnurseryapp.entity.Seed;


@Repository
public interface SeedRepository extends JpaRepository<Seed, Long>{
	
	List<Seed> findByAdmin_AdminId(Long adminId);
	Optional<Seed> findBySeedIdAndAdmin_AdminId(Long seedId, Long adminId);

}
