package com.cg.onlineplantnurseryapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnurseryapp.entity.Customer;
import com.cg.onlineplantnurseryapp.exception.ResourceNotFoundException;
import com.cg.onlineplantnurseryapp.service.ICustomerService;



@RestController 
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	//get all customers
	@GetMapping("/customers")
	public List<Customer> getCustomerList()
	{
		return customerService.getCustomerList();
	}
	
	//add new customer
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer)
	{
		return customerService.createCustomer(customer);
	}

	//get a customer by id
	@GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
        throws ResourceNotFoundException {
		return customerService.getCustomerById(customerId);
    }
	
	//get a customer by username and email
	@GetMapping("/customers/{username}/{email}")
	public ResponseEntity<Customer> getCustomerByUsernameAndEmail(@PathVariable(value = "username") String username,
			@PathVariable(value ="email") String email) throws ResourceNotFoundException {
		return customerService.getCustomerByUsernameAndEmail(username, email);
	    }
	
	//update a customer
	@PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
         @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		return customerService.updateCustomer(customerId, customerDetails);
    }
	
}