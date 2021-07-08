package com.shifting_merchant.dao;

import java.util.List;

import com.shifting_merchant.model.Merchant_booking;
import com.shifting_merchant.model.Merchant_details;

public interface Merchant_booking_dao {

	List<Merchant_booking> getbookings();

	List<Merchant_booking> getBookingsByMerchant_id(long id);

	
	String placeOrder(Merchant_booking merchant_booking);

	String update(Merchant_details merchant_profile);

	
}
