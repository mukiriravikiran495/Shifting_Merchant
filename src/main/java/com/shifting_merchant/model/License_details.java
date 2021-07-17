package com.shifting_merchant.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "license_details", uniqueConstraints = {@UniqueConstraint(columnNames = {"license_number"}) })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class License_details {

	@Id
	@Column( name = "license_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int license_id;
	
	@Column( name = "license_number")
	private long license_number;
	
	@Column( name = "registrationdate")
	private Date registrationdate;
	
	@Column( name = "expirydate")
	private Date expirydate;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn( name = "merchant_id")
	@JsonBackReference
	private Merchant_account merchant_account;
	
	

	public Merchant_account getMerchant_account() {
		return merchant_account;
	}

	public void setMerchant_account(Merchant_account merchant_account) {
		this.merchant_account = merchant_account;
	}

	public int getLicense_id() {
		return license_id;
	}

	public void setLicense_id(int license_id) {
		this.license_id = license_id;
	}

	public long getLicense_number() {
		return license_number;
	}

	public void setLicense_number(long license_number) {
		this.license_number = license_number;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	
	public License_details() {
		
	}
}
