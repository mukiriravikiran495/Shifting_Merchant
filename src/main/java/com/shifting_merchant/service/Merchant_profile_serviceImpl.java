package com.shifting_merchant.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Merchant_profile_dao;
import com.shifting_merchant.model.Merchant_profile;

@Service("merchant_profile_service")
public class Merchant_profile_serviceImpl implements Merchant_profile_service{

	@Autowired
	Merchant_profile_dao dao;
	
	

	@Override
	public Merchant_profile getdetails() {
		return dao.getdetails();
	}

}
