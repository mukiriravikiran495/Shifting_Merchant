package com.shifting_merchant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "merchant_account")
public class Merchant_account {

	@Id
	@Column(name = "merchant_id")
	private long merchant_id;
	
	@Column(name = "merchant_name")
	private String merchant_name;
	
	@Column(name = "ownerormanagername")
	private String ownerormanagername;
	
	@Column(name = "merchant_email")
	private String merchant_email;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "mobilenumber")
	private long mobilenumber;
	
	@Column( name = "registration_date")
	private Date registration_date;
	
	@OneToOne( mappedBy = "merchant_account")
	private GSTIN_details GSTIN_details;
	
	@OneToOne( mappedBy = "merchant_account")
	private License_details license_details;

	
	
	
	public String getOwnerormanagername() {
		return ownerormanagername;
	}

	public void setOwnerormanagername(String ownerormanagername) {
		this.ownerormanagername = ownerormanagername;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	@Override
	public String toString() {
		return "Merchant_account [merchant_id=" + merchant_id + ", merchant_name=" + merchant_name
				+ ", ownerormanagername=" + ownerormanagername + ", merchant_email=" + merchant_email + ", city=" + city
				+ ", mobilenumber=" + mobilenumber + ", registration_date=" + registration_date + ", GSTIN_details="
				+ GSTIN_details + ", license_details=" + license_details + "]";
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public GSTIN_details getGSTIN_details() {
		return GSTIN_details;
	}

	public void setGSTIN_details(GSTIN_details gSTIN_details) {
		GSTIN_details = gSTIN_details;
	}

	public License_details getLicense_details() {
		return license_details;
	}

	public void setLicense_details(License_details license_details) {
		this.license_details = license_details;
	}
	
	public Merchant_account() {
		
	}
}
