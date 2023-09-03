package com.foodOderingApp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodOderingApp.dto.CustomerDto;
import com.foodOderingApp.dto.EatNFunDto;
import com.foodOderingApp.dto.ResponseDto;
import com.foodOderingApp.dto.VendorsDto;
import com.foodOderingApp.repository.CustomerRepo;
import com.foodOderingApp.repository.EatNFunRepo;
import com.foodOderingApp.repository.UserRepo;
import com.foodOderingApp.repository.VendorsRepo;
import com.foodOderingApp.model.Customer;
import com.foodOderingApp.model.EatNFun;
import com.foodOderingApp.model.User;
import com.foodOderingApp.model.Vendors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CustomerRepo cusr;
	@Autowired
	private VendorsRepo vedr;
	@Autowired
	private EatNFunRepo enfr;
	
	@Autowired
	private ResponseDto responseDto;
	@Autowired
	private Customer customer;
	@Autowired
	private Vendors vendor;
	@Autowired
	private EatNFun enf;
	@Autowired
	private CustomerDto customerDto;
	@Autowired
	private VendorsDto vendorDto;
	@Autowired
	private EatNFunDto enfd;
	
	
	@GetMapping("/login")
	public Object userLogin(Principal principal) { //The principal is the currently logged in use
		String username = principal.getName();
		User user = userRepo.findByUsername(username);
		if(user == null) {
			responseDto.setMessage("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
 		}
		user.setPassword("Hidden");
		return user;
	}
	
	@GetMapping("/get/details")
	public Object getUserDetails(Principal principal) {
		String username = principal.getName();
		User user = userRepo.findByUsername(username);
		if(user == null) {
			responseDto.setMessage("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
 		}
		if(user.getRole().equalsIgnoreCase("CUSTOMER")) {
			Customer customer = cusr.findACustomerDetails(username);
			customerDto.setId(customer.getId());
			customerDto.setName(customer.getName());
			customerDto.setUsername(customer.getUser().getUsername());
			customerDto.setContact(customer.getContact());
			customerDto.setEmail(customer.getEmail());

			return customerDto;
		}

		if(user.getRole().equalsIgnoreCase("VENDORS")) {
			Vendors vendor = vedr.findVendorsDetails(username);
			vendorDto.setId(vendor.getId());
			vendorDto.setContact(vendor.getContact());
			vendorDto.setEmail(vendor.getEmail());
			vendorDto.setName(vendor.getName());
			vendorDto.setUsername(vendor.getUser().getUsername());
			vendorDto.setPassword(vendor.getUser().getPassword());
			vendorDto.setVendorCode(vendor.getVendorCode());
			
			return vendorDto;
		}

		if(user.getRole().equalsIgnoreCase("EATNFUN")) {
			//same as above .
		}
		return null;
	}

}
