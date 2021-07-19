package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.model.Reviews;
import com.shifting_merchant.service.Reviews_service;

@RestController
@RequestMapping( path = "reviews")
public class Review_controller {

	@Autowired
	Reviews_service service;
	
	@GetMapping( value = "/getallreviews")
	public List<Reviews> getallreviews(@RequestParam("merchant_id") long merchant_id){
		return service.getallreviews(merchant_id);
	}
}
