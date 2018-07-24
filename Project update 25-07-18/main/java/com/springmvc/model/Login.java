package com.springmvc.model;
public class Login {
	
	private String username;
	private String password;
	private String displayedcaptcha;
	private String enteredcaptcha;
	private int accountnumber;
	
	
	
	
	public String getDisplayedcaptcha() {
		return displayedcaptcha;
	}
	public void setDisplayedcaptcha(String displayedcaptcha) {
		this.displayedcaptcha = displayedcaptcha;
	}
	public String getEnteredcaptcha() {
		return enteredcaptcha;
	}
	public void setEnteredcaptcha(String enteredcaptcha) {
		this.enteredcaptcha = enteredcaptcha;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", displayedcaptcha=" + displayedcaptcha
				+ ", enteredcaptcha=" + enteredcaptcha + ", accountnumber=" + accountnumber + "]";
	}
	
	
	

	
	
}