package com.cg.onlineplantnurseryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.onlineplantnurseryapp.entity.Admin;
import com.cg.onlineplantnurseryapp.exception.*;
import com.cg.onlineplantnurseryapp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public ResponseEntity<Admin> getAdminById(Long adminId) throws ResourceNotFoundException {
		 Admin admin = adminRepository.findById(adminId)
		          .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
		        return ResponseEntity.ok().body(admin);
	}

	@Override
	public ResponseEntity<Admin> getAdminByAdminName(String adminName)
			throws ResourceNotFoundException {
		Admin admin = adminRepository.findByAdminName(adminName)
		          .orElseThrow(() -> new ResourceNotFoundException("Admin not found " ));
		        return ResponseEntity.ok().body(admin);
	}
	
	@Override
	public ResponseEntity<Admin> updateAdmin(Long adminId, Admin adminDetails) throws ResourceNotFoundException {
		 Admin admin = adminRepository.findById(adminId)
			        .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));

			      
			        admin.setAdminPassword(adminDetails.getAdminPassword());
			        admin.setAdminEmail(adminDetails.getAdminEmail());
			        admin.setAdminName(adminDetails.getAdminName());
			        
			        
			        final Admin updatedAdmin = adminRepository.save(admin);
			        return ResponseEntity.ok(updatedAdmin);
	}

}
