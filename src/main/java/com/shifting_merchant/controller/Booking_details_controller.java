package com.shifting_merchant.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	
	
	@GetMapping( value = "/getallongoingbookings")
	public List<Booking_details> getallongoingbookings(@RequestParam("merchant_id") long merchant_id){
		List<Booking_details> list = service.getallongoingbookings(merchant_id);
		return list;
	}
	
	@GetMapping( value = "/getallupcomingbookings")
	public List<Booking_details> getallupcomingbookings(@RequestParam("merchant_id") long merchant_id){
		List<Booking_details> list = service.getallupcomingbookings(merchant_id);
		return list;
	}
	
	@GetMapping( value = "/getallcompletedbookings")
	public List<Booking_details> getallcompletedbookings(@RequestParam("merchant_id") long merchant_id){
		List<Booking_details> list = service.getAllCompletedBookings(merchant_id);
		return list;
	}
	
	@GetMapping( value ="/getallcancelledbookings")
	public List<Booking_details> getallcancelledbookings(@RequestParam("merchant_id") long merchant_id){
		List<Booking_details> list = service.getallcancelledbookings(merchant_id);
		return list;
	}
	
	
	// get amount based on payment status paid and shiftyng payment unpaid
	@GetMapping( value = "/gettotalearnings")
	public long gettotalearnings(@RequestParam("merchant_id") long merchant_id) {
		return service.gettotalearnings(merchant_id);
	}
	
	//Today Bookings
	@GetMapping( value = "/getalltodaybookings")
	public List<Booking_details> getbookingsbypaymentdate(@RequestParam("merchant_id") long merchant_id,@RequestParam("payment_date") String payment_date){
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(payment_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service.getbookingsbypaymentdate(merchant_id, date);
	}
	
	// get total earning amount by date 
	@GetMapping( value = "/gettotalearningsbypaymentdate")
	public long gettotalearningsbypaymentdate(@RequestParam("merchant_id") long merchant_id, @RequestParam("payment_date") String payment_date) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(payment_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service.gettotalearningsbypaymentdate(merchant_id, date);
	}
	
	// operator amount page = get all bookings based on payment paid and shiftyng payment unpaid used for operator amount page
	@GetMapping( value = "/getallpaidbookings")
	public List<Booking_details> getallpaidbookings(@RequestParam("merchant_id") long merchant_id){
		List<Booking_details> list = service.getallpaidbookings(merchant_id);
		return list;
	}
		
	@GetMapping( value = "/getoperatoramount")
	public long getoperatoramount(@RequestParam("merchant_id") long merchant_id){
		return  service.getoperatoramount(merchant_id);
			
	}
		
		
		
	
}
