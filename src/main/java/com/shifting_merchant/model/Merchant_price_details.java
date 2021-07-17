package com.shifting_merchant.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "merchant_price_details")
public class Merchant_price_details {

	@Id
	@Column( name = "merchant_price_details_id")
	private int merchant_price_details_id;
	
	@Column( name = "total_amount")
	private long total_amount;
	
	@Column( name = "shift_type")
	private String Shift_type;
	
	@Column( name = "tax")
	private long tax;
	
	@Column( name = "offer")
	private int offer;
	
	@Column( name = "labour_charges")
	private long labour_charges;
	
	@Column( name = "wrapping_charges")
	private long wrapping_charges;
	
	@Column( name = "grand_total")
	private long grand_total;
	
	@Column( name = "acinstallanduninstall")
	private long acinstallanduninstall;
	
	@Column( name = "drop_date")
	private Date drop_date;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn( name = "merchant_id")
	@JsonBackReference
	private Merchant_profile merchant_profile;
	
	

	public long getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(long total_amount) {
		this.total_amount = total_amount;
	}

	public long getWrapping_charges() {
		return wrapping_charges;
	}

	public void setWrapping_charges(long wrapping_charges) {
		this.wrapping_charges = wrapping_charges;
	}

	public long getGrand_total() {
		return grand_total;
	}

	public void setGrand_total(long grand_total) {
		this.grand_total = grand_total;
	}

	public long getAcinstallanduninstall() {
		return acinstallanduninstall;
	}

	public void setAcinstallanduninstall(long acinstallanduninstall) {
		this.acinstallanduninstall = acinstallanduninstall;
	}

	public Date getDrop_date() {
		return drop_date;
	}

	public void setDrop_date(Date drop_date) {
		this.drop_date = drop_date;
	}

	public long getLabour_charges() {
		return labour_charges;
	}

	public void setLabour_charges(long labour_charges) {
		this.labour_charges = labour_charges;
	}

	
	public int getMerchant_price_details_id() {
		return merchant_price_details_id;
	}

	public void setMerchant_price_details_id(int merchant_price_details_id) {
		this.merchant_price_details_id = merchant_price_details_id;
	}

	

	public String getShift_type() {
		return Shift_type;
	}

	public void setShift_type(String shift_type) {
		Shift_type = shift_type;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public Merchant_profile getMerchant_profile() {
		return merchant_profile;
	}

	public void setMerchant_profile(Merchant_profile merchant_profile) {
		this.merchant_profile = merchant_profile;
	}

	
	
	public Merchant_price_details() {
		
	}
}
