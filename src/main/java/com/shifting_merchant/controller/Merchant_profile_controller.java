package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.model.Merchant_images;
import com.shifting_merchant.model.Merchant_price_details;
import com.shifting_merchant.model.Merchant_profile;
import com.shifting_merchant.model.Merchant_reviews;
import com.shifting_merchant.service.Merchant_profile_service;

@RestController
@RequestMapping( path = "/merchant_profile")
public class Merchant_profile_controller {

	@Autowired
	Merchant_profile_service service;
	
	
	@GetMapping( value = "/getdetails")
	public List<Merchant_profile> getprofile() {
		List<Merchant_profile> list =  (List<Merchant_profile>) service.getdetails();
		return list;
	}
	
	@GetMapping( value = "/getprofilebymerchant_id")
	public Merchant_profile getprofilebyMerchant_id(@RequestParam("merchant_id") long merchant_id) {
		Merchant_profile profile = service.getprofilebyMerchant_id(merchant_id);
		return profile;
	}
	
	@PostMapping( value = "/createprofile", headers="Accept=application/json")
	public ResponseEntity<String> createprofile(@RequestBody Merchant_profile merchant_profile){
		String message = service.createprofile(merchant_profile);
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping(value="/addimage", headers="Accept=application/json")
	public ResponseEntity<String> addImage(@RequestBody Merchant_images merchant_images, @RequestParam("merchant_id") long merchant_id){
		return service.addImage(merchant_images,merchant_id);
	}
	
	@PutMapping(value="/addreview", headers="Accept=application/json")
	public ResponseEntity<String> addreview(@RequestBody Merchant_reviews merchant_reviews, @RequestParam("merchant_id") long merchant_id){
		return service.addreview(merchant_reviews,merchant_id);
	}
	
	@DeleteMapping(value="/deleteimage", headers ="Accept=application/json")
	public ResponseEntity<String> deletereview(@RequestParam("image_id") int image_id){
		String message = service.deleteimage(image_id);
		return new ResponseEntity<String>(message,HttpStatus.GONE);
	}
	
	@PutMapping(value="/addpricedetails", headers="Accept=application/json")
	public ResponseEntity<String> addpricedetails(@RequestBody Merchant_price_details merchant_price_details, @RequestParam("merchant_id") long merchant_id){
		String message = service.addpricedetails(merchant_price_details,merchant_id);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updatepricedetails", headers="Accept=application/json")
	public ResponseEntity<String> updatepricedetails(@RequestBody Merchant_price_details merchant_price_details, @RequestParam("merchant_id") long merchant_id){
		String message = service.updatepricedetails(merchant_price_details,merchant_id);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateprofile", headers="Accept=application/json")
	public ResponseEntity<String> updateprofile(@RequestBody Merchant_profile merchant_profile, @RequestParam("merchant_id") long merchant_id){
		String message = service.updateprofile(merchant_profile,merchant_id);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	
}








