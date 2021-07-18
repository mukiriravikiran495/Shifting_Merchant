package com.shifting_merchant.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table( name = "user_reviews")
public class User_reviews {

	@Id
	@Column( name = "user_id")
	private long user_id;
	
	@OneToMany( mappedBy = "user_reviews")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Reviews> reviews;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	public User_reviews() {
		
	}
	
}
