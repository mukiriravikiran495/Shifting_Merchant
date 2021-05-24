package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.model.Booking_details;
import com.shifting_merchant.service.Booking_details_service;

@RestController
@RequestMapping("/placeorder")
public class Booking_details_controller {

	@Autowired
	Booking_details_service service;
	
	@PostMapping( value = "/placeorder")
	public ResponseEntity<String> placeOrder(@RequestBody Booking_details booking_details) {
		
		String message =  service.placeOrder(booking_details);
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@GetMapping( value = "/getlist")
	public List<Booking_details> getBookingList(){
		return service.getBookingList();
	}
	
	@GetMapping( value = "/{id}")
	public Booking_details getBookingById(@PathVariable int id	) {
		return service.getBookingById(id);
	}
	
	@GetMapping( value = "/getallinspectedbookings/{id}")
	public List<Booking_details> getAllInspectedBookings(@PathVariable int id	) {
		return service.getAllInspectedBookings(id);
	}
	
	
	
	
	//show completed orders
	@GetMapping( value = "/getallcompletedorders/{id}", headers="Accept=application/json")
	public List<Booking_details> getAllCompletedBookings(@PathVariable int id){
		return service.getAllCompletedBookings(id);
	}
	
	
	
	//complete order
	
	@PutMapping( value = "/completeorder" ,headers="Accept=application/json")
	public ResponseEntity<Booking_details> completeBooking(@RequestBody Booking_details booking_details){
		return service.completeBooking(booking_details);
	}
	//accept order
	
	@PutMapping( value = "/inspectorder" ,headers="Accept=application/json")
	public ResponseEntity<Booking_details> inspectBooking(@RequestBody Booking_details booking_details){
		return service.inspectBooking(booking_details);
	}
	
	
	
	
	
	
	
	
	
}
