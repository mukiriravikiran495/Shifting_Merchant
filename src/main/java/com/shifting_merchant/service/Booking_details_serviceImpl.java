package com.shifting_merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.shifting_merchant.dao.Booking_details_dao;

import com.shifting_merchant.model.Booking_details;

@Service("booking_details_service")
public class Booking_details_serviceImpl implements Booking_details_service{

	@Autowired
	Booking_details_dao dao;
	
	
	@Override
	public List<Booking_details> getBookingList() {
		return dao.getBookingList();
	}

	@Override
	public Booking_details getBookingById(int id) {
		return dao.getBookingById(id);
	}

	

	@Override
	public List<Booking_details> getAllCompletedBookings(int merchant_id) {
		return dao.getAllCompletedBookings(merchant_id);
	}

	@Override
	public String confirmpickup(Booking_details booking_details, long booking_id) {
		return dao.confirmpickup(booking_details, booking_id);
	}

	@Override
	public String confirmdrop(Booking_details booking_details, long booking_id) {
		return dao.confirmdrop(booking_details,booking_id);
	}

	

}
