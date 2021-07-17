package com.shifting_merchant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.Booking_details;
import com.shifting_merchant.model.Booking_status;
import com.shifting_merchant.model.Payment_mode;
import com.shifting_merchant.model.Payment_status;


@Repository("booking_details_dao")
@Transactional
public class Booking_details_daoImpl implements Booking_details_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getBookingList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details");
		List<Booking_details> list = query.list();
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Booking_details getBookingById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where booking_id = :id");
		query.setParameter("id", id);
		Booking_details booking_details = (Booking_details) query.list().get(0);
		return booking_details;
	}

	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getAllCompletedBookings(long merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where merchant_id = :merchant_id and status = :status");
		query.setParameter("status", Booking_status.BookingCompleted);
		query.setParameter("merchant_id", merchant_id);
		List<Booking_details> list = query.list();
		return list;
	}

	@Override
	public String confirmpickup(Booking_details booking_details, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details details = session.get(Booking_details.class, booking_id);
		System.out.println(details.getPayment_mode());
		booking_details.getBooking_status();
		details.getBooking_status();
		if( details.getPayment_mode() == Payment_mode.Online && details.getPayment_status() == Payment_status.Paid) {
			details.setBooking_status(Booking_status.PickupCompleted);
		}
		else {
			details.setBooking_status(Booking_status.PickupCompleted);
			details.setPayment_status(Payment_status.Paid);
			details.setPayment_mode(Payment_mode.Offline);
		}

		session.update(details);
		return "Updated .. !!";
	}

	@Override
	public String confirmdrop(Booking_details booking_details, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details details = session.get(booking_details.getClass(), booking_id);
		details.setBooking_status(Booking_status.DropCompleted);
		details.setPayment_status(Payment_status.Paid);
		session.update(details);
		
		
		return "Updated ..!!";
	}

		
	
}
