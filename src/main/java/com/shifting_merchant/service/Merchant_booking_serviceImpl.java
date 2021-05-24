package com.shifting_merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Merchant_booking_dao;
import com.shifting_merchant.model.Merchant_booking;

@Service("merchant_booking_service")
public class Merchant_booking_serviceImpl implements Merchant_booking_service{

	@Autowired
	Merchant_booking_dao dao;
	
	@Override
	public List<Merchant_booking> getbooking() {
		return dao.getbookings();
	}

	@Override
	public List<Merchant_booking> getBookingsByMerchant_id(int id) {
		
		return dao.getBookingsByMerchant_id(id);
	}

	@Override
	public String placeorder(Merchant_booking merchant_booking) {
		
		return dao.placeOrder(merchant_booking);
	}

	
	

}
