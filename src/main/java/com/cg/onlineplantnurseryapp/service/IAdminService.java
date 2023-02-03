package com.cg.onlineplantnurseryapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.cg.onlineplantnurseryapp.entity.Admin;
import com.cg.onlineplantnurseryapp.exception.*;


public interface IAdminService {
	
	public Admin createAdmin(Admin admin);
	public List<Admin> getAllAdmins();
    public ResponseEntity<Admin> getAdminById(Long adminId)
            throws ResourceNotFoundException;
    public ResponseEntity<Admin> getAdminByAdminName(String adminName) throws ResourceNotFoundException;
    public ResponseEntity<Admin> updateAdmin(Long adminId,Admin adminDetails) throws ResourceNotFoundException;
    
}
