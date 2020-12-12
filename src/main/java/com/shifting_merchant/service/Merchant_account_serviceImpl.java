package com.shifting_merchant.service;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Merchant_account_dao;
import com.shifting_merchant.model.Merchant_account;

@Service("merchant_account_service")
public class Merchant_account_serviceImpl implements Merchant_account_service {

	@Autowired
	Merchant_account_dao userDao;
	
	@Override
	public List<Merchant_account> getlist() {
		return userDao.getlist();
	}

	@Override
	public String createUser(Merchant_account merchant_account) {
		return userDao.addUser(merchant_account);
	}

	@Override
	public Merchant_account findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public Merchant_account update(Merchant_account merchant_account, int id) {
		return userDao.update(merchant_account, id);
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Merchant_account updatePartially(Merchant_account merchant_account, int id) {
		userDao.updateCountry(merchant_account,id);
		return userDao.findById(id);
	}

	@Override
	public String getOTP(Merchant_account merchant_account) {
		int otp = 0;
		String message;
		String number = String.valueOf(merchant_account.getMobilenumber());
		if(isValid(number)) {
			otp = generateOTP();
			merchant_account.setOtp(otp);
			message = userDao.getOTP(merchant_account);
			// Send to Mobile Number..
			// write code here
		}
		else {
			return "Invalid Number..!!";
		}
		return message;
	}
	
	private boolean isValid(String number) {		
		Pattern p = Pattern.compile("\\d{10}"); 
		Matcher m = p.matcher(number); 
	    return (m.find() && m.group().equals(number)); 
		
	}

	private int generateOTP() {
		int length = 4;
		char[] otp;
		String numbers = "0123456789"; 
		  
        // Using random method 
        Random rndm_method = new Random(); 
  
         otp = new char[length]; 
  
        for (int i = 0; i < length; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        int number =  Integer.parseInt(new String(otp));
        
		return number;
	}

	@Override
	public String verifyotp(Merchant_account merchant_account) {
		return userDao.verifyotp(merchant_account);
	}

	@Override
	public String resendOTP(Merchant_account merchant_account) {
		String message;
		String number = String.valueOf(merchant_account.getMobilenumber());
		if(isValid(number)) {
			
			message = userDao.resendOTP(merchant_account);
			// OT P send to Mobile Number..
			// write code here
		}
		else {
			return "Invalid Number..!!";
		}
		return message;
	}

	@Override
	public String findByEmail(Merchant_account merchant_account) {
		return userDao.findByEmail(merchant_account);
	}

	@Override
	public String resetpassword(Merchant_account merchant_account) {
		return userDao.resetpassword(merchant_account);
	}

}
