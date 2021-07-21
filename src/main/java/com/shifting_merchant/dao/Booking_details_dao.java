package com.shifting_merchant.dao;

import java.util.Date;
import java.util.List;


import com.shifting_merchant.model.Booking_details;

public interface Booking_details_dao {

	

	List<Booking_details> getBookingList();

	Booking_details getBookingById(long id);

	

	

	String confirmpickup(Booking_details booking_details, long booking_id);

	String confirmdrop(Booking_details booking_details, long booking_id);

	List<Booking_details> getallupcomingbookings(long merchant_id);

	List<Booking_details> getallongoingbookings(long merchant_id);

	List<Booking_details> getAllCompletedBookings(long merchant_id);

	List<Booking_details> getallcancelledbookings(long merchant_id);

	List<Booking_details> getallpaidbookings(long merchant_id);

	long gettotalearnings(long merchant_id);

	List<Booking_details> getbookingsbypaymentdate(long merchant_id, Date payment_date);

	long gettotalearningsbypaymentdate(long merchant_id, Date date);

	long getoperatoramount(long merchant_id);

	
}
