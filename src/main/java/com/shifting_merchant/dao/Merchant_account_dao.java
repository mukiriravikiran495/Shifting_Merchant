package com.shifting_merchant.dao;

import java.util.List;

import com.shifting_merchant.model.GSTIN_details;
import com.shifting_merchant.model.License_details;
import com.shifting_merchant.model.Merchant_account;

public interface Merchant_account_dao {

	List<Merchant_account> getMerchantaccounts();

	String createaccount(Merchant_account merchant_account, long merchant_id);

	List<GSTIN_details> getgstin_details();

	License_details findByLicense_details(long license_number);

	GSTIN_details findByGstin_number(long license_number);

	String updateaccount(Merchant_account merchant_account, long merchant_id);

}
