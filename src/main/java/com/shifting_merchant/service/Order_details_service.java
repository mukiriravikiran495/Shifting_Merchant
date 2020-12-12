package com.shifting_merchant.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_merchant.model.Order_details;


public interface Order_details_service {

	String placeOrder(Order_details order_details);

	List<Order_details> getOrderList();

	Order_details getOrderById(int id);

	ResponseEntity<Order_details> transistOrder(Order_details order_details);

	ResponseEntity<Order_details> completeOrder(Order_details order_details);

	ResponseEntity<Order_details> inspectOrder(Order_details order_details);

	List<Order_details> getAllCompletedOrders(int merchant_id);

	List<Order_details> getAllInspectedOrders(int merchant_id);

	List<Order_details> getAllTransistOrders();

}
