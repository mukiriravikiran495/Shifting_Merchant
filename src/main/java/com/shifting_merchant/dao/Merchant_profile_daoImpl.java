package com.shifting_merchant.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.Merchant_profile;

@Repository("merchant_profile_dao")
@Transactional
public class Merchant_profile_daoImpl implements Merchant_profile_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	

	@SuppressWarnings("rawtypes")
	@Override
	public Merchant_profile getdetails() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_profile");
		Merchant_profile list = (Merchant_profile) query.list().get(0);
		return list;
	}

}
