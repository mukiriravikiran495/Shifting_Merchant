package com.shifting_merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Merchant_order_dao;
import com.shifting_merchant.model.Merchant_order;

@Service("merchant_order_service")
public class Merchant_order_serviceImpl implements Merchant_order_service{

	@Autowired
	Merchant_order_dao dao;
	
	@Override
	public List<Merchant_order> getorder() {
		return dao.getorders();
	}

	@Override
	public List<Merchant_order> getOrdersByMerchant_id(int id) {
		
		return dao.getOrdersByMerchant_id(id);
	}

	@Override
	public String placeorder(Merchant_order merchant_order) {
		
		return dao.placeOrder(merchant_order);
	}

	
	

}
