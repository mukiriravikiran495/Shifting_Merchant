package com.shifting_merchant.service;

import java.util.List;



import com.shifting_merchant.model.Booking_details;


public interface Booking_details_service {

	

	List<Booking_details> getBookingList();

	Booking_details getBookingById(int id);

	

	List<Booking_details> getAllCompletedBookings(int merchant_id);

	String confirmpickup(Booking_details booking_details, long booking_id);

	String confirmdrop(Booking_details booking_details, long booking_id);

	

}
