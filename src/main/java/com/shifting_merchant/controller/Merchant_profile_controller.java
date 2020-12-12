package com.shifting_merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.model.Merchant_profile;
import com.shifting_merchant.service.Merchant_profile_service;

@RestController
@RequestMapping( path = "/merchant_profile")
public class Merchant_profile_controller {

	@Autowired
	Merchant_profile_service service;
	
	@GetMapping( value = "/getdetails")
	public Merchant_profile getprofile() {
		return service.getdetails();
	}
	
	
}
