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

import com.shifting_merchant.model.Merchant_account;
import com.shifting_merchant.service.Merchant_account_service;

@RestController
@RequestMapping( path = "/merchant_account")
public class Merchant_account_controller {

	@Autowired
	Merchant_account_service userService;
	
	@GetMapping( value = "/get")
	public List<Merchant_account> getlist(){
		return userService.getlist();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant_account> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Merchant_account merchant_account = userService.findById(id);
        if (merchant_account == null) {
            return new ResponseEntity<Merchant_account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Merchant_account>(merchant_account, HttpStatus.OK);
    }

    @PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody Merchant_account currentUser)
	{
		System.out.println("sd");
		Merchant_account user = userService.findById(currentUser.getMerchant_id());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	userService.update(currentUser, currentUser.getMerchant_id());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Merchant_account> deleteUser(@PathVariable("id") int id){
		Merchant_account user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Merchant_account>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<Merchant_account>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<Merchant_account> updateUserPartially(@PathVariable("id") int id, @RequestBody Merchant_account currentUser){
		Merchant_account user = userService.findById(id);
		if(user ==null){
			return new ResponseEntity<Merchant_account>(HttpStatus.NOT_FOUND);
		}
		Merchant_account usr =	userService.updatePartially(currentUser, id);
		return new ResponseEntity<Merchant_account>(usr, HttpStatus.OK);
	}
    
    @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<String>  createUser(@RequestBody Merchant_account merchant_account, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating User "+merchant_account.getMerchant_name());
	     String message = userService.createUser(merchant_account);
	     
	     return new ResponseEntity<String>(message,HttpStatus.OK);
	 }
    
	@PostMapping( value = "/verifyotp", headers="Accept=application/json")
    public ResponseEntity<String> verifyotp(@RequestBody  Merchant_account merchant_account ) {
    	
    	String message = userService.verifyotp(merchant_account);
    	
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    @PostMapping( value = "/sendotp", headers = "Accept=application/json")
    public ResponseEntity<String> sendOTP(@RequestBody Merchant_account merchant_account) {
    	String message = userService.getOTP(merchant_account);
    	return  new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    @PutMapping( value = "/resendotp", headers="Accept=application/json")
    public ResponseEntity<String> resendOTP(@RequestBody Merchant_account merchant_account) {
    	String message = userService.resendOTP(merchant_account);
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    @PostMapping( value = "/forgotpassword", headers = "Accept= application/json")
	public ResponseEntity<String> findByEmail(@RequestBody Merchant_account merchant_account) {
		String message =  userService.findByEmail(merchant_account);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping( value = "/resetpassword", headers="Accept=application/json")
	public ResponseEntity<String> resetpassword(@RequestBody Merchant_account merchant_account) {
		String message =  userService.resetpassword(merchant_account);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	 
}
