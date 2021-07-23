package com.shifting_merchant.model;

import java.util.Date;

public class Net_earnings_by_date {

	private Date date;
	
	private long amount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public Net_earnings_by_date() {
		
	}

	@Override
	public String toString() {
		return "Net_earnings_by_date [date=" + date + ", amount=" + amount + "]";
	}
	
	
}
