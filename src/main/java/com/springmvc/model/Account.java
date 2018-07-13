package com.springmvc.model;

public class Account {
	
	private int Number;
	private String Type;
	private int Balance;
	private java.util.Date Date;
	private String Timestamp;
	
	
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public java.util.Date getDate() {
		return Date;
	}
	public void setDate(java.util.Date date) {
		Date = date;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	
	public void display()
	{
		System.out.println("Account Number = " + Number);
		System.out.println("Account Type = " + Type);
		System.out.println("Account Balance = " + Balance);
		System.out.println("Account Date = " + Date);
		System.out.println("Account Timestamp = " + Timestamp);
	}

}
