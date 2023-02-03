package com.cg.onlineplantnurseryapp.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnurseryapp.entity.Plant;


@Repository
public interface PlantRepository extends JpaRepository<Plant, Long>{
	
	List<Plant> findByAdmin_AdminId(Long adminId);
	Optional<Plant> findByPlantIdAndAdmin_AdminId(Long plantId, Long adminId);

}
