package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.model.Booking_details;
import com.shifting_merchant.service.Booking_details_service;

@RestController
@RequestMapping("/booking")
public class Booking_details_controller {

	@Autowired
	Booking_details_service service;
	
	
	@GetMapping( value = "/getlist")
	public List<Booking_details> getBookingList(){
		return service.getBookingList();
	}
	
	@GetMapping( value = "/{id}")
	public Booking_details getBookingById(@PathVariable int id	) {
		return service.getBookingById(id);
	}
	
	
	
	//show completed orders
	@GetMapping( value = "/getallcompletedorders/{id}", headers="Accept=application/json")
	public List<Booking_details> getAllCompletedBookings(@PathVariable int id){
		return service.getAllCompletedBookings(id);
	}
	
	@PutMapping( value = "/confirmpickup", headers="Accept=application/json")
	public String confirmPickup(@RequestBody Booking_details booking_details, @RequestParam("booking_id") long booking_id) {
		String message = service.confirmpickup(booking_details, booking_id);
		return message;
	}
	
	@PutMapping( value = "/confirmdrop", headers="Accept=application/json")
	public String confirmdrop(@RequestBody Booking_details booking_details, @RequestParam("booking_id") long booking_id) {
		String message = service.confirmdrop(booking_details,booking_id);
		return message;
	}
	
	
}
