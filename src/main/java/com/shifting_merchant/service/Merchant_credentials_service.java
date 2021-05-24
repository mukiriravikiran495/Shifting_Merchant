package com.shifting_merchant.service;

import java.util.List;

import com.shifting_merchant.model.Merchant_credentials;

public interface Merchant_credentials_service {

	List<Merchant_credentials> getlist();

	public String createUser(Merchant_credentials merchant_credentials);
	
	public Merchant_credentials findById(long id);
	public Merchant_credentials update(Merchant_credentials merchant_credentials, long id);
	public void deleteUserById(long id);
	public Merchant_credentials updatePartially(Merchant_credentials merchant_credentials, long id);
	public String getOTP(Merchant_credentials merchant_credentials);
	public String verifyotp(Merchant_credentials merchant_credentials);
	public String resendOTP(Merchant_credentials merchant_credentials);
	public String findByEmail(Merchant_credentials merchant_credentials);
	public String resetpassword(Merchant_credentials merchant_credentials);
	
}
