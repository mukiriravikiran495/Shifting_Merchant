package com.shifting_merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.shifting_merchant.dao.Booking_details_dao;

import com.shifting_merchant.model.Booking_details;

@Service("booking_details_service")
public class Booking_details_serviceImpl implements Booking_details_service{

	@Autowired
	Booking_details_dao dao;
	
	@Override
	public String placeOrder(Booking_details booking_details) {
		return dao.placeOrder(booking_details);
		
	}

	@Override
	public List<Booking_details> getBookingList() {
		return dao.getBookingList();
	}

	@Override
	public Booking_details getBookingById(int id) {
		return dao.getBookingById(id);
	}

	@Override
	public ResponseEntity<Booking_details> transistBooking(Booking_details booking_details) {
		return dao.transistBooking(booking_details);
	}

	@Override
	public ResponseEntity<Booking_details> completeBooking(Booking_details booking_details) {
		return dao.completeBooking(booking_details);
	}

	@Override
	public ResponseEntity<Booking_details> inspectBooking(Booking_details booking_details) {
		return dao.inspectBooking(booking_details);
	}

	@Override
	public List<Booking_details> getAllCompletedBookings(int merchant_id) {
		return dao.getAllCompletedBookings(merchant_id);
	}

	@Override
	public List<Booking_details> getAllInspectedBookings(int merchant_id) {
		return dao.getAllInspectedBookings(merchant_id);
	}

	@Override
	public List<Booking_details> getAllTransistBookings() {
		return dao.getAllTransistBookings();
	}

}
