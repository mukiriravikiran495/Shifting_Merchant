package com.shifting_merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Order_details_dao;
import com.shifting_merchant.model.Order_details;

@Service("order_details_service")
public class Order_details_serviceImpl implements Order_details_service{

	@Autowired
	Order_details_dao dao;
	
	@Override
	public String placeOrder(Order_details order_details) {
		return dao.placeOrder(order_details);
		
	}

	@Override
	public List<Order_details> getOrderList() {
		return dao.getOrderList();
	}

	@Override
	public Order_details getOrderById(int id) {
		return dao.getOrderById(id);
	}

	@Override
	public ResponseEntity<Order_details> transistOrder(Order_details order_details) {
		return dao.transistOrder(order_details);
	}

	@Override
	public ResponseEntity<Order_details> completeOrder(Order_details order_details) {
		return dao.completeOrder(order_details);
	}

	@Override
	public ResponseEntity<Order_details> inspectOrder(Order_details order_details) {
		return dao.inspectOrder(order_details);
	}

	@Override
	public List<Order_details> getAllCompletedOrders(int merchant_id) {
		return dao.getAllCompletedOrders(merchant_id);
	}

	@Override
	public List<Order_details> getAllInspectedOrders(int merchant_id) {
		return dao.getAllInspectedOrders(merchant_id);
	}

	@Override
	public List<Order_details> getAllTransistOrders() {
		return dao.getAllTransistOrders();
	}

}
