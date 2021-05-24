package com.shifting_merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Merchant_account_dao;
import com.shifting_merchant.model.GSTIN_details;
import com.shifting_merchant.model.License_details;
import com.shifting_merchant.model.Merchant_account;

@Service("merchant_account_service")
public class Merchant_account_serviceImpl implements Merchant_account_service{

	@Autowired
	Merchant_account_dao dao;
	
	@Override
	public List<Merchant_account> getMerchantaccounts() {
		List<Merchant_account> list = dao.getMerchantaccounts();
		return list;
	}

	@Override
	public String createaccount(Merchant_account merchant_account) {
		return dao.createaccount(merchant_account);
	}

	@Override
	public List<GSTIN_details> getgstin_details() {
		return dao.getgstin_details();
	}

	@Override
	public License_details findByLicense_details(long license_number) {
		return dao.findByLicense_details(license_number);
	}

	

	@Override
	public GSTIN_details findByGstin_number(long license_number) {
		return dao.findByGstin_number(license_number);
	}

}
