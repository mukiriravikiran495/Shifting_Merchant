package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Merchant_booking> getBookingsByMerchant_id(@PathVariable long id){
		return service.getBookingsByMerchant_id(id);		
	}
	
	
	
	@PostMapping( value = "/update", headers="Accept=application/json")
	public String update(Merchant_details merchant_profile) {
		
		return dao.update(merchant_profile);
	}
	
	
	@GetMapping( value = "/getallupcomingbookings")
	public List<Merchant_booking> getallupcomingbookings(@RequestParam("merchant_id") long merchant_id){
		List<Merchant_booking> list = service.getallupcomingbookings(merchant_id);
		return list;
	}
	
	
	@GetMapping( value = "/getallongoingbookings")
	public List<Merchant_booking> getallongoingbookings(@RequestParam("merchant_id") long merchant_id){
		List<Merchant_booking> list = service.getallongoingbookings(merchant_id);
		return list;
	}
	
	@GetMapping( value = "/getallcompletedbookings")
	public List<Merchant_booking> getallcompletedbookings(@RequestParam("merchant_id") long merchant_id){
		List<Merchant_booking> list = service.getallcompletedbookings(merchant_id);
		return list;
	}
	
}
