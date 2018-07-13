package com.springmvc.model;

public class UIDAI {
	
	int accountnumber;
	String pan;
	String aadhaar;
	
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}
	
	
	public void display()
	{
		System.out.println("account : " + accountnumber);
		System.out.println("aadhaar : " + aadhaar);
		System.out.println("pan : " + pan);
	}
	
	

}
