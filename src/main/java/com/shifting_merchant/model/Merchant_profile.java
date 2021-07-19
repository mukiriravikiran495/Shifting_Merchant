package com.shifting_merchant.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table( name = "merchant_profile")
public class Merchant_profile {

	@Id
	@Column( name = "merchant_id")
	private long merchant_id;
	
	@Column( name = "merchant_name")
	private String merchant_name;
	
	@Column( name = "merchant_email")
	private String merchant_email;
	
	@Column( name = "city")
	private String city;
	
	@Column( name = "mobilenumber")
	private long mobilenumber;
	
	
	
	@OneToMany( mappedBy = "merchant_profile",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Merchant_images> Merchant_images;
	
	
	
	@OneToOne( mappedBy = "merchant_profile")
	private Merchant_price_details merchant_price_details;
	
	
	
	public Merchant_price_details getMerchant_price_details() {
		return merchant_price_details;
	}

	public void setMerchant_price_details(Merchant_price_details merchant_price_details) {
		this.merchant_price_details = merchant_price_details;
	}

	

	public Set<Merchant_images> getMerchant_images() {
		return Merchant_images;
	}

	public void setMerchant_images(Set<Merchant_images> merchant_images) {
		Merchant_images = merchant_images;
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

	

	public String getMerchant_email() {
		return merchant_email;
	}

	public void setMerchant_email(String merchant_email) {
		this.merchant_email = merchant_email;
	}
	
	
}
