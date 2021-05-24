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
@Table( name = "gstin_details", uniqueConstraints = {@UniqueConstraint(columnNames = {"gstin_number"}) })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GSTIN_details {

	@Id
	@Column( name = "gstin_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gstin_id;
	
	@Column( name = "gstin_number")
	private long gstin_number;
	
	@Column( name = "gstin_tradename")
	private String gstin_tradename;
	
	@Column( name = "gstin_registrationdate")
	private Date gstin_registrationdate;
	
	@Column( name = "gstin_city")
	private String gstin_city;
	
	@Column( name = "gstin_state")
	private String gstin_state;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn( name = "merchant_id")
	@JsonBackReference
	private Merchant_account merchant_account;

	

	@Override
	public String toString() {
		return "GSTIN_details [gstin_id=" + gstin_id + ", gstin_number=" + gstin_number + ", gstin_tradename="
				+ gstin_tradename + ", gstin_registrationdate=" + gstin_registrationdate + ", gstin_city=" + gstin_city
				+ ", gstin_state=" + gstin_state + ", merchant_account=" + merchant_account + "]";
	}

	public Merchant_account getMerchant_account() {
		return merchant_account;
	}

	public void setMerchant_account(Merchant_account merchant_account) {
		this.merchant_account = merchant_account;
	}

	public int getGstin_id() {
		return gstin_id;
	}

	public void setGstin_id(int gstin_id) {
		this.gstin_id = gstin_id;
	}

	public long getGstin_number() {
		return gstin_number;
	}

	public void setGstin_number(long gstin_number) {
		this.gstin_number = gstin_number;
	}

	public String getGstin_tradename() {
		return gstin_tradename;
	}

	public void setGstin_tradename(String gstin_tradename) {
		this.gstin_tradename = gstin_tradename;
	}

	public Date getGstin_registrationdate() {
		return gstin_registrationdate;
	}

	public void setGstin_registrationdate(Date gstin_registrationdate) {
		this.gstin_registrationdate = gstin_registrationdate;
	}

	public String getGstin_city() {
		return gstin_city;
	}

	public void setGstin_city(String gstin_city) {
		this.gstin_city = gstin_city;
	}

	public String getGstin_state() {
		return gstin_state;
	}

	public void setGstin_state(String gstin_state) {
		this.gstin_state = gstin_state;
	}
	
	public GSTIN_details() {
		
	}
}
