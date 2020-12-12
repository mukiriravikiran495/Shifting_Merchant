package com.shifting_merchant.dao;




import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shifting_merchant.model.Merchant_order;
import com.shifting_merchant.model.Merchant_profile;

@Repository("merchant_order_dao")
@Transactional
public class Merchant_order_daoImpl implements Merchant_order_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_order> getorders() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_order");
		List<Merchant_order>list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_order> getOrdersByMerchant_id(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_order where merchant_id = :id");
		query.setParameter("id", id);
		List<Merchant_order> merchant_order =  query.list();
		return merchant_order;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private Merchant_order findById(int merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_order where merchant_id = :merchant_id");
		query.setParameter("merchant_id", merchant_id);
		Merchant_order merchant_order = (Merchant_order) query.list().get(0);
		return merchant_order;
	}
	
	

	
	@Override
	public String placeOrder(Merchant_order val) {
		return null;
		
		
	
	}

	@Override
	public String update(Merchant_profile merchant_profile) {
		
		return null;
	}

	

	
	
	
}
