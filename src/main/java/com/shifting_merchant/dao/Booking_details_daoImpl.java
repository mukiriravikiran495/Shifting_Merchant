package com.shifting_merchant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.Booking_details;
import com.shifting_merchant.model.Status;


@Repository("booking_details_dao")
@Transactional
public class Booking_details_daoImpl implements Booking_details_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String placeOrder(Booking_details val) {
		
		
		return "Created ..!!";
	}

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

	@Override
	public ResponseEntity<Booking_details> transistBooking(Booking_details val) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details booking_details = getBookingById(val.getBooking_id());
		booking_details.setStatus(Status.transist);
		session.update(booking_details);
		return new ResponseEntity<Booking_details>(booking_details,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Booking_details> completeBooking(Booking_details val) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details booking_details = getBookingById(val.getBooking_id());
		booking_details.setStatus(Status.Completed);
		session.update(booking_details);
		return new ResponseEntity<Booking_details>(booking_details,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Booking_details> inspectBooking(Booking_details val) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details booking_details = getBookingById(val.getBooking_id());
		booking_details.setStatus(Status.Accepted);
		session.update(booking_details);
		return new ResponseEntity<Booking_details>(booking_details,HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getAllCompletedBookings(long merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where merchant_id = :merchant_id and status = :status");
		query.setParameter("status", Status.Completed);
		query.setParameter("merchant_id", merchant_id);
		List<Booking_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getAllInspectedBookings(long merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(merchant_id);
		Query query = session.createQuery("from Booking_details where merchant_id = :merchant_id and status = :status  ");
		query.setParameter("merchant_id", merchant_id);
		query.setParameter("status", Status.Accepted);
		List<Booking_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getAllTransistBookings() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where status = :status");
		query.setParameter("status", Status.transist);
		List<Booking_details> list = query.list();
		return list;
	}

	
	
}
