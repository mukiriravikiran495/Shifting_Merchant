package com.shifting_merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shifting_merchant.model.Merchant_credentials;
import com.shifting_merchant.service.Merchant_credentials_service;

@RestController
@RequestMapping( path = "/merchant_credentials")
public class Merchant_credentials_controller {

	@Autowired
	Merchant_credentials_service userService;
	
	@GetMapping( value = "/get")
	public List<Merchant_credentials> getlist(){
		return userService.getlist();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant_credentials> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Merchant_credentials merchant_credentials = userService.findById(id);
        if (merchant_credentials == null) {
            return new ResponseEntity<Merchant_credentials>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Merchant_credentials>(merchant_credentials, HttpStatus.OK);
    }

    @PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody Merchant_credentials currentUser)
	{
		System.out.println("sd");
		Merchant_credentials user = userService.findById(currentUser.getMerchant_id());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	userService.update(currentUser, currentUser.getMerchant_id());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Merchant_credentials> deleteUser(@PathVariable("id") int id){
		Merchant_credentials user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Merchant_credentials>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<Merchant_credentials>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<Merchant_credentials> updateUserPartially(@PathVariable("id") int id, @RequestBody Merchant_credentials currentUser){
		Merchant_credentials user = userService.findById(id);
		if(user ==null){
			return new ResponseEntity<Merchant_credentials>(HttpStatus.NOT_FOUND);
		}
		Merchant_credentials usr =	userService.updatePartially(currentUser, id);
		return new ResponseEntity<Merchant_credentials>(usr, HttpStatus.OK);
	}
    
    @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<String>  createUser(@RequestBody Merchant_credentials merchant_account, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating User "+merchant_account.getMerchant_name());
	     String message = userService.createUser(merchant_account);
	     
	     return new ResponseEntity<String>(message,HttpStatus.OK);
	}
    
	@PostMapping( value = "/verifyotp", headers="Accept=application/json")
    public ResponseEntity<String> verifyotp(@RequestBody  Merchant_credentials merchant_account ) {
    	
    	String message = userService.verifyotp(merchant_account);
    	
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    @PostMapping( value = "/sendotp", headers = "Accept=application/json")
    public ResponseEntity<String> sendOTP(@RequestBody Merchant_credentials merchant_account) {
    	String message = userService.getOTP(merchant_account);
    	return  new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    @PutMapping( value = "/resendotp", headers="Accept=application/json")
    public ResponseEntity<String> resendOTP(@RequestBody Merchant_credentials merchant_account) {
    	String message = userService.resendOTP(merchant_account);
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    @PostMapping( value = "/forgotpassword", headers = "Accept= application/json")
	public ResponseEntity<String> findByEmail(@RequestBody Merchant_credentials merchant_account) {
		String message =  userService.findByEmail(merchant_account);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping( value = "/resetpassword", headers="Accept=application/json")
	public ResponseEntity<String> resetpassword(@RequestBody Merchant_credentials merchant_account) {
		String message =  userService.resetpassword(merchant_account);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	 
}
