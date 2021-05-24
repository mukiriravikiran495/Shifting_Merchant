package com.shifting_merchant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "merchant_reviews")
public class Merchant_reviews {

	@Id
	@Column( name = "review_id")
	private int review_id;
	
	@Column( name = "rating")
	private int rating;
	
	@Column( name = "description")
	private String description;

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn( name = "merchant_id")
	@JsonBackReference
	private Merchant_profile merchant_profile;
	
	
	
	public Merchant_profile getMerchant_profile() {
		return merchant_profile;
	}

	public void setMerchant_profile(Merchant_profile merchant_profile) {
		this.merchant_profile = merchant_profile;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Merchant_reviews() {
		
	}
	
}
