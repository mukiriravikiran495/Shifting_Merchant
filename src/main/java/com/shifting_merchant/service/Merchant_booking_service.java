package com.shifting_merchant.service;

import java.util.List;


import com.shifting_merchant.model.Merchant_booking;

public interface Merchant_booking_service {

	List<Merchant_booking> getbooking();

	List<Merchant_booking> getBookingsByMerchant_id(long id);

	
	

	List<Merchant_booking> getallupcomingbookings(long merchant_id);

	List<Merchant_booking> getallongoingbookings( long merchant_id);

	List<Merchant_booking> getallcompletedbookings( long merchant_id);

	
}
