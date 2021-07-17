package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_merchant.model.GSTIN_details;
import com.shifting_merchant.model.License_details;
import com.shifting_merchant.model.Merchant_account;
import com.shifting_merchant.service.Merchant_account_service;

@RestController
@RequestMapping( path = "/merchant_account")
public class Merchant_account_controller {

	@Autowired
	Merchant_account_service service;
	
	@GetMapping( value = "/getmerchantaccounts")
	public List<Merchant_account> getMerchantaccounts(){
		List<Merchant_account> list = service.getMerchantaccounts();
		return list;
	}
	
	@PostMapping(value = "/createaccount",  headers="Accept=application/json")
	public ResponseEntity<String> createaccount(@RequestBody Merchant_account merchant_account){
		String message = service.createaccount(merchant_account);
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping( value = "/getgstin_details")
	public List<GSTIN_details> getgstin_details(){
		List<GSTIN_details> list = service.getgstin_details();
		return list;
	}
	
	@GetMapping( value = "/getlicensedetails")
	public License_details findByLicense_details(@RequestParam("license_number") long license_number) {
		License_details details = service.findByLicense_details(license_number);
		return details;
	}
	
	@GetMapping( value = "/getgstindetails")
	public GSTIN_details findByGstin_details(@RequestParam("gstin_number") long gstin_number) {
		GSTIN_details details = service.findByGstin_number(gstin_number);
		return details;
	}
}
