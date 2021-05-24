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
@Table( name = "merchant_images")
public class Merchant_images {

	@Id
	@Column( name = "image_id")
	private int image_id;
	
	@Column( name = "image")
	private String image;
	
	
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn( name = "merchant_id")
	@JsonBackReference
	private Merchant_profile merchant_profile;

	
	
	
	@Override
	public String toString() {
		return "Merchant_images [image_id=" + image_id + ", image=" + image + ", merchant_profile=" + merchant_profile
				+ "]";
	}

	public Merchant_profile getMerchant_profile() {
		return merchant_profile;
	}

	public void setMerchant_profile(Merchant_profile merchant_profile) {
		this.merchant_profile = merchant_profile;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Merchant_images() {
		
	}
}
