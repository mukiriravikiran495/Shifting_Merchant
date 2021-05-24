package com.shifting_merchant.model;



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
@Table( name = "final_price_details")
public class Final_price_details {

	@Id
	@Column( name = "final_price_details_id")
	private int final_price_details_id;
	
	@Column( name = "amount")
	private int amount;
	
	@Column( name = "tax")
	private int tax;
	
	@Column( name = "offer")
	private int offer;
	
	@Column( name = "installanduninstall")
	private int installanduninstall;
	
	@Column( name = "labour_charges")
	private int labour_charges;
	
	@Column( name = "final_amount")
	private long final_amount;
	
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn( name = "booking_id")
	@JsonBackReference
	private Booking_details booking_details;

	public int getFinal_price_details_id() {
		return final_price_details_id;
	}

	public void setFinal_price_details_id(int final_price_details_id) {
		this.final_price_details_id = final_price_details_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public int getInstallanduninstall() {
		return installanduninstall;
	}

	public void setInstallanduninstall(int installanduninstall) {
		this.installanduninstall = installanduninstall;
	}

	public int getLabour_charges() {
		return labour_charges;
	}

	public void setLabour_charges(int labour_charges) {
		this.labour_charges = labour_charges;
	}

	

	public long getFinal_amount() {
		return final_amount;
	}

	public void setFinal_amount(long final_amount) {
		this.final_amount = final_amount;
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
