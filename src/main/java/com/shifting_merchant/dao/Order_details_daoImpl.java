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

import com.shifting_merchant.model.Order_details;
import com.shifting_merchant.model.Status;


@Repository("order_details_dao")
@Transactional
public class Order_details_daoImpl implements Order_details_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String placeOrder(Order_details val) {
		
		
		return "Created ..!!";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Order_details> getOrderList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order_details");
		List<Order_details> list = query.list();
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Order_details getOrderById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order_details where order_id = :id");
		query.setParameter("id", id);
		Order_details order_details = (Order_details) query.list().get(0);
		return order_details;
	}

	@Override
	public ResponseEntity<Order_details> transistOrder(Order_details val) {
		Session session = sessionFactory.getCurrentSession();
		Order_details order_details = getOrderById(val.getOrder_id());
		order_details.setStatus(Status.transist);
		session.update(order_details);
		return new ResponseEntity<Order_details>(order_details,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Order_details> completeOrder(Order_details val) {
		Session session = sessionFactory.getCurrentSession();
		Order_details order_details = getOrderById(val.getOrder_id());
		order_details.setStatus(Status.Completed);
		session.update(order_details);
		return new ResponseEntity<Order_details>(order_details,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Order_details> inspectOrder(Order_details val) {
		Session session = sessionFactory.getCurrentSession();
		Order_details order_details = getOrderById(val.getOrder_id());
		order_details.setStatus(Status.Accepted);
		session.update(order_details);
		return new ResponseEntity<Order_details>(order_details,HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Order_details> getAllCompletedOrders(int merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order_details where merchant_id = :merchant_id and status = :status");
		query.setParameter("status", Status.Completed);
		query.setParameter("merchant_id", merchant_id);
		List<Order_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Order_details> getAllInspectedOrders(int merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(merchant_id);
		Query query = session.createQuery("from Order_details where merchant_id = :merchant_id and status = :status  ");
		query.setParameter("merchant_id", merchant_id);
		query.setParameter("status", Status.Accepted);
		List<Order_details> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Order_details> getAllTransistOrders() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order_details where status = :status");
		query.setParameter("status", Status.transist);
		List<Order_details> list = query.list();
		return list;
	}

	
	
}
