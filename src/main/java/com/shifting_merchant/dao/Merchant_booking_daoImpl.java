package com.shifting_merchant.dao;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.Merchant_booking;
import com.shifting_merchant.model.Merchant_details;

@Repository("merchant_order_dao")
@Transactional
public class Merchant_booking_daoImpl implements Merchant_booking_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_booking> getbookings() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_booking");
		List<Merchant_booking>list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_booking> getBookingsByMerchant_id(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_booking where merchant_id = :id");
		query.setParameter("id", id);
		List<Merchant_booking> merchant_booking =  query.list();
		return merchant_booking;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private Merchant_booking findById(int merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_booking where merchant_id = :merchant_id");
		query.setParameter("merchant_id", merchant_id);
		Merchant_booking merchant_booking = (Merchant_booking) query.list().get(0);
		return merchant_booking;
	}
	
	

	
	@Override
	public String placeOrder(Merchant_booking val) {
		return null;
		
		
	
	}

	@Override
	public String update(Merchant_details merchant_profile) {
		
		return null;
	}

	

	
	
	
}
