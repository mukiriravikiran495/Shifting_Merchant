package com.shifting_merchant.dao;

import java.util.List;

import com.shifting_merchant.model.Merchant_booking;
import com.shifting_merchant.model.Merchant_details;

public interface Merchant_booking_dao {

	List<Merchant_booking> getbookings();

	List<Merchant_booking> getBookingsByMerchant_id(long id);

	
	

	String update(Merchant_details merchant_profile);

	List<Merchant_booking> getallupcomingbookings(long merchant_id);

	List<Merchant_booking> getallongoingbookings(long merchant_id);

	List<Merchant_booking> getallcompletedbookings(long merchant_id);

	
}
