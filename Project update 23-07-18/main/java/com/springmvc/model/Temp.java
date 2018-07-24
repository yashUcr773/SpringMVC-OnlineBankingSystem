package com.springmvc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Temp {

	private String username;
	@DateTimeFormat(pattern = "DD-MM-YYYY")
	private Date date;
	String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void display()
	{
		System.out.println("User name : " + username);
		System.out.println("Date : " + date);
		System.out.println("Country : " + country);
	}
}
