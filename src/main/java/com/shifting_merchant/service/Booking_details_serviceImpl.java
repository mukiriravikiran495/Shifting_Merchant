package com.shifting_merchant.service;

import java.util.Date;
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
	public String confirmpickup(Booking_details booking_details, long booking_id) {
		return dao.confirmpickup(booking_details, booking_id);
	}

	@Override
	public String confirmdrop(Booking_details booking_details, long booking_id) {
		return dao.confirmdrop(booking_details,booking_id);
	}

	@Override
	public List<Booking_details> getallongoingbookings(long merchant_id) {
		return dao.getallongoingbookings(merchant_id);
	}

	@Override
	public List<Booking_details> getallupcomingbookings(long merchant_id) {
		return dao.getallupcomingbookings(merchant_id);
	}

	@Override
	public List<Booking_details> getAllCompletedBookings(long merchant_id) {
		return dao.getAllCompletedBookings(merchant_id);
	}

	@Override
	public List<Booking_details> getallcancelledbookings(long merchant_id) {
		return dao.getallcancelledbookings(merchant_id);
	}

	@Override
	public List<Booking_details> getallpaidbookings(long merchant_id) {
		return dao.getallpaidbookings(merchant_id);
	}

	@Override
	public long gettotalearnings(long merchant_id) {
		return dao.gettotalearnings(merchant_id);
	}

	@Override
	public List<Booking_details> getbookingsbypaymentdate(long merchant_id, Date payment_date) {
		return dao.getbookingsbypaymentdate(merchant_id, payment_date);
	}

	@Override
	public long gettotalearningsbypaymentdate(long merchant_id, Date date) {
		return dao.gettotalearningsbypaymentdate(merchant_id, date);
	}

	@Override
	public long getoperatoramount(long merchant_id) {
		return dao.getoperatoramount(merchant_id);
	}

	@Override
	public long getcurrentbalance(long merchant_id) {
		return dao.getcurrentbalance(merchant_id);
	}

	@Override
	public List<Booking_details> getalltodaybooking(long merchant_id) {
		return dao.getalltodaybookings(merchant_id);
	}

	

	

}
