package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.dao.Merchant_order_dao;
import com.shifting_merchant.model.Merchant_order;
import com.shifting_merchant.model.Merchant_profile;
import com.shifting_merchant.service.Merchant_order_service;

@RestController
@RequestMapping( path = "/merchant_order")
public class Merchant_order_controller {

	@Autowired
	Merchant_order_service service;
	
	@Autowired
	Merchant_order_dao dao;
	// get all records 
	@GetMapping(value = "/getorders")
	public List<Merchant_order> getorders(){
		return service.getorder();
	}
	
	// get all records based on merchant_id
	@GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant_order> getOrdersByMerchant_id(@PathVariable int id){
		return service.getOrdersByMerchant_id(id);		
	}
	
	@PostMapping( value = "/placeorder",  headers="Accept=application/json")
	public ResponseEntity<String> placeOrder(@RequestBody Merchant_order merchant_order) {
		String message =  service.placeorder(merchant_order);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PostMapping( value = "/update", headers="Accept=application/json")
	public String update(Merchant_profile merchant_profile) {
		
		return dao.update(merchant_profile);
	}
	
	
}
