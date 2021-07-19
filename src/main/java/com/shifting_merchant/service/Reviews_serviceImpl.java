package com.shifting_merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_merchant.dao.Reviews_dao;
import com.shifting_merchant.model.Reviews;

@Service("review_service")
public class Reviews_serviceImpl implements Reviews_service{

	@Autowired
	Reviews_dao dao;
	
	@Override
	public List<Reviews> getallreviews(long merchant_id) {
		return dao.getallreviews(merchant_id);
	}

}
