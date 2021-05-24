package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.dao.Merchant_booking_dao;
import com.shifting_merchant.model.Merchant_booking;
import com.shifting_merchant.model.Merchant_details;
import com.shifting_merchant.service.Merchant_booking_service;

@RestController
@RequestMapping( path = "/merchant_booking")
public class Merchant_booking_controller {

	@Autowired
	Merchant_booking_service service;
	
	@Autowired
	Merchant_booking_dao dao;
	// get all records 
	@GetMapping(value = "/getorders")
	public List<Merchant_booking> getbookings(){
		return service.getbooking();
	}
	
	// get all records based on merchant_id
	@GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant_booking> getBookingsByMerchant_id(@PathVariable int id){
		return service.getBookingsByMerchant_id(id);		
	}
	
	@PostMapping( value = "/placeorder",  headers="Accept=application/json")
	public ResponseEntity<String> placeOrder(@RequestBody Merchant_booking merchant_booking) {
		String message =  service.placeorder(merchant_booking);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PostMapping( value = "/update", headers="Accept=application/json")
	public String update(Merchant_details merchant_profile) {
		
		return dao.update(merchant_profile);
	}
	
	
}
