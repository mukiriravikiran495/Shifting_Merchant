package com.shifting_merchant.service;

import java.util.List;

import com.shifting_merchant.model.Reviews;

public interface Reviews_service {

	List<Reviews> getallreviews(long merchant_id);

}
