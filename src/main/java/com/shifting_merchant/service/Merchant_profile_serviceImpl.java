package com.shifting_merchant.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Merchant_profile_dao;
import com.shifting_merchant.model.Merchant_images;
import com.shifting_merchant.model.Merchant_price_details;
import com.shifting_merchant.model.Merchant_profile;
import com.shifting_merchant.model.Merchant_reviews;

@Service("merchant_profile_service")
public class Merchant_profile_serviceImpl implements Merchant_profile_service{

	@Autowired
	Merchant_profile_dao dao;
	
	
	@Override
	public List<Merchant_profile> getdetails() {
		List<Merchant_profile> list =  (List<Merchant_profile>) dao.getdetails();
		return list;
	}


	@Override
	public Merchant_profile getprofilebyMerchant_id(long merchant_id) {
		Merchant_profile profile = dao.getprofilebyMerchant_id(merchant_id);
		return profile;
	}


	@Override
	public String createprofile(Merchant_profile merchant_profile, long merchant_id) {
		return dao.createprofile(merchant_profile, merchant_id);
	}


	@Override
	public ResponseEntity<String> addImage(Merchant_images merchant_images,long merchant_id) {
		return dao.addImage(merchant_images,merchant_id);
	}


	@Override
	public ResponseEntity<String> addreview(Merchant_reviews merchant_reviews, long merchant_id) {
		return dao.addreview(merchant_reviews,merchant_id);
	}


	@Override
	public String deleteimage(int image_id) {
		return dao.deleteimage(image_id);
	}


	@Override
	public String addpricedetails(Merchant_price_details merchant_price_details, long merchant_id) {
		return dao.addpricedetails(merchant_price_details, merchant_id);
	}


	@Override
	public String updatepricedetails(Merchant_price_details merchant_price_details, long merchant_id) {
		return dao.updatepricedetails(merchant_price_details,merchant_id);
	}




	@Override
	public String updateprofile(Merchant_profile merchant_profile, long merchant_id) {
		return dao.updateprofile(merchant_profile,merchant_id);
	}


	

	

}
