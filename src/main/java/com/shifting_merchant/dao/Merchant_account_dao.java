package com.shifting_merchant.dao;

import java.util.List;

import com.shifting_merchant.model.Merchant_account;

public interface Merchant_account_dao {

	List<Merchant_account> getlist();
	public String addUser(Merchant_account merchant_account);
	
	public Merchant_account findById(int id);
	public Merchant_account update(Merchant_account merchant_account, int id);
	public Merchant_account updateCountry(Merchant_account merchant_account, int id);
	public void delete(int id);
	public String getOTP(Merchant_account merchant_account);
	public String verifyotp(Merchant_account merchant_account);
	public String resendOTP(Merchant_account merchant_account);
	public String findByEmail(Merchant_account merchant_account);
	public String resetpassword(Merchant_account merchant_account);
	
}
