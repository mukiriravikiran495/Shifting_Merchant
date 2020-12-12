package com.shifting_merchant.service;

import java.util.List;

import com.shifting_merchant.model.Merchant_account;

public interface Merchant_account_service {

	List<Merchant_account> getlist();

	public String createUser(Merchant_account merchant_account);
	
	public Merchant_account findById(int id);
	public Merchant_account update(Merchant_account merchant_account, int id);
	public void deleteUserById(int id);
	public Merchant_account updatePartially(Merchant_account merchant_account, int id);
	public String getOTP(Merchant_account merchant_account);
	public String verifyotp(Merchant_account merchant_account);
	public String resendOTP(Merchant_account merchant_account);
	public String findByEmail(Merchant_account merchant_account);
	public String resetpassword(Merchant_account merchant_account);
	
}
