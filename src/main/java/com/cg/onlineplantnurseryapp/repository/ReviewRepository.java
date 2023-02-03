package com.cg.onlineplantnurseryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlineplantnurseryapp.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	}
