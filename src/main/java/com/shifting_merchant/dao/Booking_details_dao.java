package com.shifting_merchant.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_merchant.model.Booking_details;

public interface Booking_details_dao {

	String placeOrder(Booking_details booking_details);

	List<Booking_details> getBookingList();

	Booking_details getBookingById(long id);

	ResponseEntity<Booking_details> transistBooking(Booking_details booking_details);

	ResponseEntity<Booking_details> completeBooking(Booking_details booking_details);

	ResponseEntity<Booking_details> inspectBooking(Booking_details booking_details);

	List<Booking_details> getAllCompletedBookings(long merchant_id);

	List<Booking_details> getAllInspectedBookings(long merchant_id);

	List<Booking_details> getAllTransistBookings();

}
