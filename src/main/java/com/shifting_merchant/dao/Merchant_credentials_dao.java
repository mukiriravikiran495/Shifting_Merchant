package com.shifting_merchant.dao;

import java.util.List;

import com.shifting_merchant.model.Merchant_credentials;

public interface Merchant_credentials_dao {

	List<Merchant_credentials> getlist();
	public String addUser(Merchant_credentials merchant_account);
	
	public Merchant_credentials findById(long id);
	public Merchant_credentials update(Merchant_credentials merchant_account, long id);
	public Merchant_credentials updateCountry(Merchant_credentials merchant_account, long id);
	public void delete(long id);
	public String getOTP(Merchant_credentials merchant_account);
	public String verifyotp(Merchant_credentials merchant_account);
	public String resendOTP(Merchant_credentials merchant_account);
	public String findByEmail(Merchant_credentials merchant_account);
	public String resetpassword(Merchant_credentials merchant_account);
	
}
