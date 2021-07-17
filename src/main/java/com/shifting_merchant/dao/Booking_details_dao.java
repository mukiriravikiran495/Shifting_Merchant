package com.shifting_merchant.dao;

import java.util.List;


import com.shifting_merchant.model.Booking_details;

public interface Booking_details_dao {

	

	List<Booking_details> getBookingList();

	Booking_details getBookingById(long id);

	

	List<Booking_details> getAllCompletedBookings(long merchant_id);

	String confirmpickup(Booking_details booking_details, long booking_id);

	String confirmdrop(Booking_details booking_details, long booking_id);

	

}
