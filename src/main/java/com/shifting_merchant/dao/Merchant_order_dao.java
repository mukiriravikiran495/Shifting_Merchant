package com.shifting_merchant.dao;

import java.util.List;


import com.shifting_merchant.model.Merchant_order;
import com.shifting_merchant.model.Merchant_profile;

public interface Merchant_order_dao {

	List<Merchant_order> getorders();

	List<Merchant_order> getOrdersByMerchant_id(int id);

	
	String placeOrder(Merchant_order merchant_order);

	String update(Merchant_profile merchant_profile);

	
}
