package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.model.Order_details;
import com.shifting_merchant.service.Order_details_service;

@RestController
@RequestMapping("/placeorder")
public class Order_details_controller {

	@Autowired
	Order_details_service service;
	
	@PostMapping( value = "/placeorder")
	public ResponseEntity<String> placeOrder(@RequestBody Order_details order_details) {
		
		String message =  service.placeOrder(order_details);
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@GetMapping( value = "/getlist")
	public List<Order_details> getOrderList(){
		return service.getOrderList();
	}
	
	@GetMapping( value = "/{id}")
	public Order_details getOrderById(@PathVariable int id	) {
		return service.getOrderById(id);
	}
	
	@GetMapping( value = "/getallinspectedorders/{id}")
	public List<Order_details> getAllInspectedOrders(@PathVariable int id	) {
		return service.getAllInspectedOrders(id);
	}
	
	
	
	
	//show completed orders
	@GetMapping( value = "/getallcompletedorders/{id}", headers="Accept=application/json")
	public List<Order_details> getAllCompletedOrders(@PathVariable int id){
		return service.getAllCompletedOrders(id);
	}
	
	
	
	//complete order
	
	@PutMapping( value = "/completeorder" ,headers="Accept=application/json")
	public ResponseEntity<Order_details> completeOrder(@RequestBody Order_details order_details){
		return service.completeOrder(order_details);
	}
	//accept order
	
	@PutMapping( value = "/inspectorder" ,headers="Accept=application/json")
	public ResponseEntity<Order_details> inspectOrder(@RequestBody Order_details order_details){
		return service.inspectOrder(order_details);
	}
	
	
	
	
	
	
	
	
	
}
