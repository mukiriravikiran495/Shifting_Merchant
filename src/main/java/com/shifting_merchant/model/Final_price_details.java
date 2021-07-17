package com.shifting_merchant.model;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "final_price_details")
public class Final_price_details {

	@Id
	@Column( name = "final_price_details_id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int frinal_price_details_id;
	
	@Column( name = "total_amount")
	private long total_amount;
	
	@Column( name = "tollgate_charges")
	private int tollgate_charges;
	
	@Column( name = "tax")
	private int tax;
	
	@Column( name = "labour_charges")
	private int labour_charges;
	
	@Column( name = "acinstallanduninstall")
	private int acinstallanduninstall;
	
	@Column( name = "wrapping_charges")
	private int wrapping_charges;
	
	@Column( name = "grand_total")
	private long grand_total;
	
	@Column( name = "offer")
	private int offer;
	
	
	
	public int getOffer() {
		return offer;
	}



	public void setOffer(int offer) {
		this.offer = offer;
	}



	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn( name = "booking_id")
	@JsonBackReference
	private Booking_details booking_details;

	
	
	public int getFrinal_price_details_id() {
		return frinal_price_details_id;
	}



	public void setFrinal_price_details_id(int frinal_price_details_id) {
		this.frinal_price_details_id = frinal_price_details_id;
	}



	public long getTotal_amount() {
		return total_amount;
	}



	public void setTotal_amount(long total_amount) {
		this.total_amount = total_amount;
	}



	public int getTollgate_charges() {
		return tollgate_charges;
	}



	public void setTollgate_charges(int tollgate_charges) {
		this.tollgate_charges = tollgate_charges;
	}



	public int getTax() {
		return tax;
	}



	public void setTax(int tax) {
		this.tax = tax;
	}



	public int getLabour_charges() {
		return labour_charges;
	}



	public void setLabour_charges(int labour_charges) {
		this.labour_charges = labour_charges;
	}



	public int getAcinstallanduninstall() {
		return acinstallanduninstall;
	}



	public void setAcinstallanduninstall(int acinstallanduninstall) {
		this.acinstallanduninstall = acinstallanduninstall;
	}



	public int getWrapping_charges() {
		return wrapping_charges;
	}



	public void setWrapping_charges(int wrapping_charges) {
		this.wrapping_charges = wrapping_charges;
	}



	public long getGrand_total() {
		return grand_total;
	}



	public void setGrand_total(long grand_total) {
		this.grand_total = grand_total;
	}



	public Booking_details getBooking_details() {
		return booking_details;
	}



	public void setBooking_details(Booking_details booking_details) {
		this.booking_details = booking_details;
	}



	public Final_price_details() {
		
	}
	
}
