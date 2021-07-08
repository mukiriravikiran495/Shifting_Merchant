package com.shifting_merchant.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_merchant.model.Merchant_images;
import com.shifting_merchant.model.Merchant_price_details;
import com.shifting_merchant.model.Merchant_profile;
import com.shifting_merchant.model.Merchant_reviews;

public interface Merchant_profile_service {

	
	List<Merchant_profile> getdetails();

	Merchant_profile getprofilebyMerchant_id(long merchant_id);

	String createprofile(Merchant_profile merchant_profile, long merchant_id);

	ResponseEntity<String> addImage(Merchant_images merchant_images,long merchant_id);

	ResponseEntity<String> addreview(Merchant_reviews merchant_reviews, long merchant_id);

	String deleteimage(int image_id);

	String addpricedetails(Merchant_price_details merchant_price_details, long merchant_id);

	String updatepricedetails(Merchant_price_details merchant_price_details, long merchant_id);

	String updateprofile(Merchant_profile merchant_profile, long merchant_id);

	
}
