package com.cg.onlineplantnurseryapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnurseryapp.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Optional<Admin> findByAdminName(String adminName );

}
