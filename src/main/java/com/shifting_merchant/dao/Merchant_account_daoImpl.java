package com.shifting_merchant.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_merchant.model.Merchant_account;
import com.shifting_merchant.model.Merchant_order;
import com.shifting_merchant.model.Merchant_profile;

@Repository("merchant_account_dao")
@Transactional
public class Merchant_account_daoImpl implements Merchant_account_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_account> getlist() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_account");
		List<Merchant_account> list = query.list();
		return list;
	}

	@Override
	public String addUser(Merchant_account val) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				Merchant_account user = findById(val.getMerchant_id());
				if( user.getMerchant_email() == null ) {	
					user.setMerchant_email(val.getMerchant_email());
					user.setMerchant_name(val.getMerchant_name());
					user.setMerchant_password(val.getMerchant_password());
					session.save(user); 
					Merchant_profile user_profile = new Merchant_profile();
					user_profile.setMerchant_profile_id(val.getMerchant_id());
					user_profile.setMerchant_email(val.getMerchant_email());
					user_profile.setMobilenumber(val.getMobilenumber());
					//session.save(user_profile);
					Merchant_order merchant_order = new Merchant_order();
					merchant_order.setMerchant_id(val.getMerchant_id());
					session.save(merchant_order);
					return " User Created";
				}			
				else {						
					return "User already Exists ..!!";
				}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Merchant_account findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_account where  merchant_id=:userid");
		query.setParameter("userid", id);
		return (Merchant_account) query.list().get(0);
	}

	@Override
	public Merchant_account update(Merchant_account merchant_account, int id) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_account user =(Merchant_account)session.get(Merchant_account.class, id);
		
		user.setMerchant_name(merchant_account.getMerchant_name());
		session.update(user);
		return user;
	}

	@Override
	public Merchant_account updateCountry(Merchant_account merchant_account, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_account user = findById(id);
		session.delete(user);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String getOTP(Merchant_account merchant_account) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_account where mobilenumber ="+merchant_account.getMobilenumber());
		List<Merchant_account> list = query.list();
		
		if(list.isEmpty()) {
			session.save(merchant_account);
			return "OTP sent Succesfully to "+merchant_account.getMobilenumber();
			
		}
		else {
			Merchant_account user2 = list.get(0);
			if(merchant_account.getMobilenumber() == user2.getMobilenumber() && user2.getMerchant_email() == null) {
				return "OTP has already sent to "+merchant_account.getMobilenumber();
			}
			return "account already exists";	
		}
	}

	@Override
	public String verifyotp(Merchant_account merchant_account) {
		Merchant_account user = findById(merchant_account.getMerchant_id());
		if(merchant_account.getOtp() == user.getOtp()) {
			return "Verified ..!! ";
		}else {
			return "Invalid OTP please enter again ..!!:";
		}
	}

	@SuppressWarnings({ "rawtypes", "null" })
	@Override
	public String resendOTP(Merchant_account merchant_account) {
		int otp = 0;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_account where mobilenumber ="+merchant_account.getMobilenumber());
		Merchant_account user = (Merchant_account) query.list().get(0);
		
		if(user == null) {
			return user.getMobilenumber()+" Number Not Exists ";
		}
		
		
			otp = generateOTP();
			user.setOtp(otp);
			session.update(user);
			return "OTP sent again Succesfully to "+user.getMobilenumber();
		
	}

	private int generateOTP() {
		int length = 4;
		char[] otp;
		String numbers = "0123456789"; 
		  
        // Using random method 
        Random rndm_method = new Random(); 
  
         otp = new char[length]; 
  
        for (int i = 0; i < length; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        int number =  Integer.parseInt(new String(otp));
        
		return number;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String findByEmail(Merchant_account merchant_account) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_account where merchant_email = :email");
		query.setParameter("email", merchant_account.getMerchant_email());
		List<Merchant_account> user2 =  query.list();
		if( user2.isEmpty()) {
			return "Mail Id not  Exists ..!!";
		}else
			return "Email Id  exists ..!!";
	}

	@Override
	public String resetpassword(Merchant_account merchant_account) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_account user2 = findById(merchant_account.getMerchant_id());
		if( user2.getMerchant_password().equals(merchant_account.getMerchant_password())) {
			return "Please try with new Password ..!!";
		}else {
			user2.setMerchant_password(merchant_account.getMerchant_password());
			session.update(user2);
			return " password reset succesfully ..!!";
		}
	}

}
