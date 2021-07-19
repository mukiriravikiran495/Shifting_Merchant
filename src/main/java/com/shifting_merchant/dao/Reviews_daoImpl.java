package com.shifting_merchant.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shifting_merchant.model.Reviews;

@Repository("review_dao")
@Transactional
public class Reviews_daoImpl implements Reviews_dao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Reviews> getallreviews(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_reviews where merchant_id = :merchant_id");
		query.setParameter("merchant_id", id);
		List<Reviews> list = query.list();
		return list;
	}

}
