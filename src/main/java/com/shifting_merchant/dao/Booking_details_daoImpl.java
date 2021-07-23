package com.shifting_merchant.dao;



import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.Booking_details;
import com.shifting_merchant.model.Booking_status;
import com.shifting_merchant.model.Final_price_details;
import com.shifting_merchant.model.Net_earnings_by_date;
import com.shifting_merchant.model.Payment_mode;
import com.shifting_merchant.model.Payment_status;
import com.shifting_merchant.model.Shiftyng_payment_status;


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

	

	

	@Override
	public String confirmpickup(Booking_details booking_details, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details details = session.get(Booking_details.class, booking_id);
		System.out.println("payment_mode "+details.getPayment_mode());
		System.out.println("details "+details);
	
		if( details.getPayment_mode() == Payment_mode.Online && details.getPayment_status() == Payment_status.Paid) {
			details.setBooking_status(Booking_status.PickupCompleted);
		}
		else {
			details.setBooking_status(Booking_status.PickupCompleted);
			details.setPayment_status(Payment_status.Paid);
			details.setPayment_mode(Payment_mode.Offline);
			Date date = new Date();
			details.setPayment_date(date);
			Final_price_details price= details.getFinal_price_details();
			System.out.println("final_price_details "+price);
			long grand_total = price.getGrand_total();
			
			long shiftyng_amount = (grand_total * 2)/100;
			long operator_amount = grand_total - shiftyng_amount;
			price.setOperator_amount(operator_amount);
			price.setShiftyng_amount(shiftyng_amount);
			session.update(price);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getallupcomingbookings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where booking_status = :status and merchant_id = :merchant_id");
		query.setParameter("status", Booking_status.BookingCompleted);
		query.setParameter("merchant_id", id);
		List<Booking_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getallongoingbookings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where booking_status = :status and merchant_id = :merchant_id");
		query.setParameter("status", Booking_status.PickupCompleted);
		query.setParameter("merchant_id", id);
		List<Booking_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getAllCompletedBookings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where booking_status = :status and merchant_id = :merchant_id and shiftyng_payment_status = :s");
		query.setParameter("status", Booking_status.DropCompleted);
		query.setParameter("merchant_id", id);
		query.setParameter("s", Shiftyng_payment_status.Unpaid);
		List<Booking_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getallcancelledbookings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where booking_status = :status and merchant_id = :merchant_id");
		query.setParameter("status", Booking_status.BookingCancelled);
		query.setParameter("merchant_id", id);
		List<Booking_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getallpaidbookings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where payment_status = :status and merchant_id = :merchant_id and shiftyng_payment_status = :s");
		query.setParameter("status", Payment_status.Paid);
		query.setParameter("s", Shiftyng_payment_status.Unpaid);
		query.setParameter("merchant_id", id);
		List<Booking_details> list = query.list();
		return list;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public long gettotalearnings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where payment_status = :status and merchant_id = :merchant_id and shiftyng_payment_status = :s" );
		query.setParameter("status", Payment_status.Paid);
		query.setParameter("s", Shiftyng_payment_status.Unpaid);
		query.setParameter("merchant_id", id);
		List<Booking_details> list = query.list();
		long total_earnings = 0;
		Booking_details details = null;
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			details = (Booking_details) itr.next();
			total_earnings = total_earnings + details.getFinal_price_details().getGrand_total();
		}
		return total_earnings;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getbookingsbypaymentdate(long id, Date payment_date) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where payment_status = :status  and merchant_id = :merchant_id and payment_date = :date");
		query.setParameter("merchant_id", id);
		query.setParameter("status", Payment_status.Paid);
		
		query.setParameter("date", payment_date);
		List<Booking_details> list = query.list();
		return list;
		
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public long gettotalearningsbypaymentdate(long id, Date payment_date) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Hello...");
		Query query = session.createQuery("from Booking_details where payment_status = :status  and merchant_id = :merchant_id and payment_date = :date");
		query.setParameter("merchant_id", id);
		query.setParameter("status", Payment_status.Paid);
		
		query.setParameter("date", payment_date);
		List<Booking_details> list = query.list();
		Booking_details details = null;
		long grand_total = 0;
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			details = (Booking_details) itr.next();
			grand_total = grand_total+ details.getFinal_price_details().getGrand_total();
		}
		
		return grand_total;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public long getoperatoramount(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where payment_status = :status and merchant_id = :merchant_id and shiftyng_payment_status = :s");
		query.setParameter("status", Payment_status.Paid);
		query.setParameter("s", Shiftyng_payment_status.Unpaid);
		query.setParameter("merchant_id", id);
		List<Booking_details> list = query.list();
		Booking_details details = null;
		Iterator itr = list.iterator();
		long operator_amount = 0;
		while(itr.hasNext()) {
			details = (Booking_details) itr.next();
			operator_amount = operator_amount + details.getFinal_price_details().getOperator_amount();
		}
		return operator_amount;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public long getcurrentbalance(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where payment_status = :status and merchant_id = :merchant_id and shiftyng_payment_status = :s and payment_date = :date");
		query.setParameter("status", Payment_status.Paid);
		query.setParameter("merchant_id", id);
		query.setParameter("s", Shiftyng_payment_status.Unpaid);
		Date payment_date = new Date();
		query.setParameter("date", payment_date);
		List<Booking_details> list = query.list();
		Booking_details details = null;
		long total = 0;
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			details = (Booking_details) itr.next();
			total = total + details.getFinal_price_details().getGrand_total();
			
		}
		return total;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getalltodaybookings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where payment_status = :status and merchant_id = :merchant_id and shiftyng_payment_status = :s and payment_date = :date");
		query.setParameter("status", Payment_status.Paid);
		query.setParameter("merchant_id", id);
		query.setParameter("s", Shiftyng_payment_status.Unpaid);
		Date payment_date = new Date();
		query.setParameter("date", payment_date);
		List<Booking_details> list = query.list();
		return list;
	}

	
	@SuppressWarnings({ "rawtypes", "null", "unused" })
	@Override
	public List<Net_earnings_by_date> getnetearningsbydate(long merchant_id) {
		
		
		Date startdate = null, enddate = null;
		startdate = new Date();
			
			Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.DATE, -7);
	        Date todate1 = cal.getTime();     
	        
	        
		
		//Date d = new Date();
		Calendar start = Calendar.getInstance();
		start.setTime(startdate);
		Calendar end = Calendar.getInstance();
		end.setTime(todate1);

		for (Date date = start.getTime(); start.before(end);  date = start.getTime()) {
		    // Do your job here with `date`.
		    System.out.println("date     "  +date);
		    List<Booking_details> l = getbookingdetails(merchant_id,date);
		    Iterator itr = l.iterator();
		    Booking_details details = null;
		    List<Net_earnings_by_date> list = null ;
		    Net_earnings_by_date net = null ;
		    while(itr.hasNext()) {
		    	details = (Booking_details) itr.next();
		    	net.setDate(details.getPickup_date());
		    	net.setAmount(details.getFinal_price_details().getGrand_total());
		    	list.add(net);
		    	
		    }
		    return list;
		    
		}
        
		
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Booking_details> getbookingdetails(long id, Date d) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where merchant_id = :merchant_id and payment_date = :date and payment_status = :status");
		query.setParameter("merchant_id", id);
		query.setParameter("date", d);
		query.setParameter("status", Payment_status.Paid);
		List<Booking_details> list = query.list();
		return list;
	}

	

	
		
	
}
