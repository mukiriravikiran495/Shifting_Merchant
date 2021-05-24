package com.shifting_merchant.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.GSTIN_details;
import com.shifting_merchant.model.License_details;
import com.shifting_merchant.model.Merchant_account;

@Repository("merchant_account_dao")
@Transactional
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Merchant_account_daoImpl implements Merchant_account_dao{

	@Autowired
	SessionFactory factory;
	
	
	@Override
	public List<Merchant_account> getMerchantaccounts() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from Merchant_account");
		List<Merchant_account> list = query.list();
		return list;
	}


	@Override
	public String createaccount(Merchant_account merchant_account) {
		Session session = factory.getCurrentSession();
		
		Merchant_account account = findByMerchant_id(merchant_account.getMerchant_id());
		System.out.println(account);
		if(account == null) {
			System.out.println("Please Login ..!!");
		}
		else {
			GSTIN_details gstdetails = new GSTIN_details();
			
			account.setCity(merchant_account.getCity());
			account.setMerchant_email(merchant_account.getMerchant_email());
			account.setMerchant_id(merchant_account.getMerchant_id());
			account.setMerchant_name(merchant_account.getMerchant_name());
			account.setMobilenumber(merchant_account.getMobilenumber());
			
			
			gstdetails.setGstin_id(merchant_account.getGSTIN_details().getGstin_id());
			gstdetails.setGstin_number(merchant_account.getGSTIN_details().getGstin_number());
			gstdetails.setGstin_registrationdate(merchant_account.getGSTIN_details().getGstin_registrationdate());
			gstdetails.setGstin_state(merchant_account.getGSTIN_details().getGstin_state());
			gstdetails.setGstin_tradename(merchant_account.getGSTIN_details().getGstin_tradename());
			gstdetails.setGstin_city(merchant_account.getGSTIN_details().getGstin_city());
			gstdetails.setMerchant_account(account);
			
				session.save(gstdetails);
			
			
			License_details license_details = new License_details();
			license_details.setExpirydate(merchant_account.getLicense_details().getExpirydate());
			license_details.setLicense_id(merchant_account.getLicense_details().getLicense_id());
			license_details.setLicense_number(merchant_account.getLicense_details().getLicense_number());
			license_details.setRegistrationdate(merchant_account.getLicense_details().getRegistrationdate());
			license_details.setMerchant_account(account);
			
			session.save(license_details);
			
			
			session.update(account);
			
			return "Merchant_account created";
		}
		return " ";
		
	}


	


	private Merchant_account findByMerchant_id(long id) {
		Session session =factory.getCurrentSession();
		Query query = session.createQuery("from Merchant_account where merchant_id = :merchant_id");
		query.setParameter("merchant_id", id);
		Merchant_account account = (Merchant_account) query.list().get(0);
		return account;
	}


	@Override
	public List<GSTIN_details> getgstin_details() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from GSTIN_details");
		List<GSTIN_details>list = query.list();
		return list;
		
	}


	@Override
	public License_details findByLicense_details(long number) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from License_details where license_number = : license_number");
		query.setParameter("license_number", number);
		License_details license = (License_details) query.list().get(0);
		return license;
	}


	@Override
	public GSTIN_details findByGstin_number(long number) {
		Session session  = factory.getCurrentSession();
		Query query = session.createQuery("from GSTIN_details where gstin_number = :gstin_number");
		query.setParameter("gstin_number", number);
		GSTIN_details details = (GSTIN_details) query.list().get(0);
		return details;
	}

}
