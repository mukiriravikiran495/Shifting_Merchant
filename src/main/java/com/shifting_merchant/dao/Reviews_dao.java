package com.shifting_merchant.dao;

import java.util.List;

import com.shifting_merchant.model.Reviews;

public interface Reviews_dao {

	List<Reviews> getallreviews(long merchant_id);

}
