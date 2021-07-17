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
@Table( name = "booking_transaction_details")
public class Booking_transaction_details {

	@Id
	@Column( name = "booking_transaction_id")
	private int booking_transaction_id;
	
	@Column( name = "transaction_id")
	private int transaction_id;
	
	@Column( name = "transaction_date")
	private Date transaction_date;
	
	private Payment_mode payment_mode = Payment_mode.Unpaid;
	
	private Transaction_status transaction_status = Transaction_status.Pending;
	
	

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn( name = "booking_id")
	@JsonBackReference
	private Booking_details booking_details;
	
	


	public Transaction_status getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(Transaction_status transaction_status) {
		this.transaction_status = transaction_status;
	}

	public void setBooking_transaction_id(int booking_transaction_id) {
		this.booking_transaction_id = booking_transaction_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	
	public Payment_mode getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(Payment_mode payment_mode) {
		this.payment_mode = payment_mode;
	}

	

	public int getBooking_transaction_id() {
		return booking_transaction_id;
	}

	public Booking_details getBooking_details() {
		return booking_details;
	}

	public void setBooking_details(Booking_details booking_details) {
		this.booking_details = booking_details;
	}

	public Booking_transaction_details() {
		
	}
}
