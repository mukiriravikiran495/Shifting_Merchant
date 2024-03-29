package com.shifting_merchant.dao;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_merchant.model.Merchant_images;
import com.shifting_merchant.model.Merchant_price_details;
import com.shifting_merchant.model.Merchant_profile;

public interface Merchant_profile_dao {

	
	List<Merchant_profile> getdetails();

	Merchant_profile getprofilebyMerchant_id(long merchant_id);

	
	ResponseEntity<String> addImage(Merchant_images merchant_images, long merchant_id);

	
	String deleteimage(int image_id);

	String addpricedetails(Merchant_price_details merchant_price_details, long merchant_id);

	String updatepricedetails(Merchant_price_details merchant_price_details, long merchant_id);

	String updateprofile(Merchant_profile merchant_profile, long merchant_id);

	
}
