package com.shifting_merchant.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_merchant.model.Booking_details;


public interface Booking_details_service {

	String placeOrder(Booking_details booking_details);

	List<Booking_details> getBookingList();

	Booking_details getBookingById(int id);

	ResponseEntity<Booking_details> transistBooking(Booking_details booking_details);

	ResponseEntity<Booking_details> completeBooking(Booking_details booking_details);

	ResponseEntity<Booking_details> inspectBooking(Booking_details booking_details);

	List<Booking_details> getAllCompletedBookings(int merchant_id);

	List<Booking_details> getAllInspectedBookings(int merchant_id);

	List<Booking_details> getAllTransistBookings();

}
