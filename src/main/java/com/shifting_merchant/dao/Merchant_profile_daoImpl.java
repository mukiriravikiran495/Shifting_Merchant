package com.shifting_merchant.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.Merchant_images;
import com.shifting_merchant.model.Merchant_price_details;
import com.shifting_merchant.model.Merchant_profile;


@Repository("merchant_profile_dao")
@Transactional
public class Merchant_profile_daoImpl implements Merchant_profile_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Merchant_profile> getdetails() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_profile");
		List<Merchant_profile> list = (List<Merchant_profile>) query.list();
		return list;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public Merchant_profile getprofilebyMerchant_id(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_profile where merchant_id = : merchant_id");
		query.setParameter("merchant_id", id);
		Merchant_profile profile = (Merchant_profile) query.list().get(0);
		return profile;
	}


	
	@Override
	public ResponseEntity<String> addImage(Merchant_images merchant_images, long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Merchant_profile profile = session.get(Merchant_profile.class, id);
		
		
		Merchant_images img = new Merchant_images();
		img.setImage(merchant_images.getImage());
		img.setImage_id(merchant_images.getImage_id());
		img.setMerchant_profile(profile);
		session.save(img);
		session.update(profile);
		return new ResponseEntity<String>( "Images added Succesfully.. !!",HttpStatus.CREATED);
	}


	
	
	@Override
	public String addpricedetails(Merchant_price_details merchant_price_details, long merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_profile profile  = session.get(Merchant_profile.class, merchant_id);
		Merchant_price_details details = new Merchant_price_details();
		
		details.setMerchant_price_details_id(merchant_price_details.getMerchant_price_details_id());
		details.setTotal_amount(merchant_price_details.getTotal_amount());
		details.setShift_type(merchant_price_details.getShift_type());
		details.setAcinstallanduninstall(merchant_price_details.getAcinstallanduninstall());
		details.setDrop_date(merchant_price_details.getDrop_date());
		details.setGrand_total(merchant_price_details.getGrand_total());
		details.setLabour_charges(merchant_price_details.getLabour_charges());
		details.setTax(merchant_price_details.getTax());
		details.setOffer(merchant_price_details.getOffer());
		details.setWrapping_charges(merchant_price_details.getWrapping_charges());
		details.setMerchant_profile(profile);
		
		
		
		//session.saveOrUpdate(details);
		session.save(details);
		return null;
	}
	
	@Override
	public String deleteimage(int image_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Merchant_images image = findByimage_id(image_id);
		if (image == null) {
			return "Review not Found ..!!";
		}else {
			session.delete(image);
			return " Review Deleted Succesfully ..!!";
		}
		
		
	}


	@SuppressWarnings("rawtypes")
	private Merchant_images findByimage_id(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_images where image_id = :image_id");
		query.setParameter("image_id", id);
		Merchant_images image = (Merchant_images) query.list().get(0);
		return image;
	}


	@Override
	public String updatepricedetails(Merchant_price_details merchant_price_details, long merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_profile profile = session.get(Merchant_profile.class, merchant_id);
		
		Merchant_price_details details = session.get(Merchant_price_details.class, merchant_price_details.getMerchant_price_details_id());
		if(details == null) {
			return "Not Found ..!!";
		}else {
			
			details.setTotal_amount(merchant_price_details.getTotal_amount());
			details.setShift_type(merchant_price_details.getShift_type());
			details.setAcinstallanduninstall(merchant_price_details.getAcinstallanduninstall());
			details.setDrop_date(merchant_price_details.getDrop_date());
			details.setGrand_total(merchant_price_details.getGrand_total());
			details.setLabour_charges(merchant_price_details.getLabour_charges());
			details.setTax(merchant_price_details.getTax());
			details.setOffer(merchant_price_details.getOffer());
			details.setWrapping_charges(merchant_price_details.getWrapping_charges());
			details.setMerchant_profile(profile);
			session.update(details);
		}
		return " Updated..!! ";
	}


	@Override
	public String updateprofile(Merchant_profile merchant_profile, long merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_profile profile = session.get(Merchant_profile.class, merchant_id);
		if(profile == null) {
			return "Not Found ..!!";
		}
		else {
			profile.setCity(merchant_profile.getCity());
			profile.setMerchant_email(merchant_profile.getMerchant_email());
			profile.setMerchant_id(merchant_profile.getMerchant_id());
			profile.setMerchant_name(merchant_profile.getMerchant_name());
			profile.setMobilenumber(merchant_profile.getMobilenumber());
			session.update(profile);
		}
		return " ";
	}


	


	


	

}
