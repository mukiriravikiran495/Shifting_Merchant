package com.shifting_merchant.service;

import java.util.List;

import com.shifting_merchant.model.GSTIN_details;
import com.shifting_merchant.model.License_details;
import com.shifting_merchant.model.Merchant_account;

public interface Merchant_account_service {

	List<Merchant_account> getMerchantaccounts();

	String createaccount(Merchant_account merchant_account);

	List<GSTIN_details> getgstin_details();

	License_details findByLicense_details(long license_number);

	GSTIN_details findByGstin_number(long license_number);

}
