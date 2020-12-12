package com.shifting_merchant.service;

import java.util.List;


import com.shifting_merchant.model.Merchant_order;

public interface Merchant_order_service {

	List<Merchant_order> getorder();

	List<Merchant_order> getOrdersByMerchant_id(int id);

	
	String placeorder(Merchant_order merchant_order);

	
}
