package com.shifting_merchant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table( name = "merchant_credentials")
public class Merchant_credentials {

	@Id
	@Column( name = "merchant_id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long merchant_id;
	
	@Column( name = "merchant_name")
	private String merchant_name;
	
	@Column( name = "merchant_email")
	private String merchant_email;
	
	@Column( name = "mobilenumber")
	private long mobilenumber;
	
	@Column( name = "merchant_password")
	private String merchant_password;
	
	@Column( name = "otp")
	private int otp;

	
	
	
	public long getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getMerchant_email() {
		return merchant_email;
	}

	public void setMerchant_email(String merchant_email) {
		this.merchant_email = merchant_email;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getMerchant_password() {
		return merchant_password;
	}

	public void setMerchant_password(String merchant_password) {
		this.merchant_password = merchant_password;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	
	

	public Merchant_credentials() {
		
	}
}
