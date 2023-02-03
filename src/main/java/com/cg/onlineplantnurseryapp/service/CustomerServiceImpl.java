package com.cg.onlineplantnurseryapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnurseryapp.repository.CustomerRepository;
import com.cg.onlineplantnurseryapp.entity.Customer;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomerList() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public ResponseEntity<Customer> getCustomerById(Long customerId) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
		          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
		        return ResponseEntity.ok().body(customer);
	}

	@Override
	public ResponseEntity<Customer> getCustomerByUsernameAndEmail(String username, String email)
			throws ResourceNotFoundException {
		 Customer customer = customerRepository.findByUsernameAndEmail(username, email)
		          .orElseThrow(() -> new ResourceNotFoundException("Customer not found "));
		        return ResponseEntity.ok().body(customer);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Long customerId, Customer customerDetails)
			throws ResourceNotFoundException {
		  Customer customer = customerRepository.findById(customerId)
			        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

			        customer.setEmail(customerDetails.getEmail());
			        customer.setName(customerDetails.getName());
			        customer.setMobileNumber(customerDetails.getMobileNumber());
			        customer.setUsername(customerDetails.getUsername());
			        customer.setPassword(customerDetails.getPassword());
			        
			        final Customer updatedCustomer = customerRepository.save(customer);
			        return ResponseEntity.ok(updatedCustomer);
	}

}
