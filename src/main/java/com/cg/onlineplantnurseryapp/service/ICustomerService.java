package com.cg.onlineplantnurseryapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineplantnurseryapp.entity.Customer;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;

public interface ICustomerService {
	public List<Customer> getCustomerList();
	public Customer createCustomer(Customer customer);
    public ResponseEntity<Customer> getCustomerById(Long customerId) throws ResourceNotFoundException;
	public ResponseEntity<Customer> getCustomerByUsernameAndEmail(String username,String email) throws ResourceNotFoundException;
    public ResponseEntity<Customer> updateCustomer(Long customerId,
           Customer customerDetails) throws ResourceNotFoundException;

}
