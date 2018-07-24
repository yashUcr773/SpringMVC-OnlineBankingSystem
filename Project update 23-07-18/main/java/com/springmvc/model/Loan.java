package com.springmvc.model;

public class Loan {

	int loanid;
	int accountnumber;
	float rate;
	float principle;
	float tenure;
	double emi;
	float amountpaid;
	String tos;
	
	
	public String getTos() {
		return tos;
	}
	public void setTos(String tos) {
		this.tos = tos;
	}
	public int getLoanid() {
		return loanid;
	}
	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getPrinciple() {
		return principle;
	}
	public void setPrinciple(float principle) {
		this.principle = principle;
	}
	public float getTenure() {
		return tenure;
	}
	public void setTenure(float tenure) {
		this.tenure = tenure;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi() {
		
		float r=rate/100;
		emi = (principle*r)*(Math.pow(1+r, tenure*12))/(Math.pow(1+r, tenure*12)-1);
		emi=Math.round(emi);
	}
	public float getAmountpaid() {
		return amountpaid;
	}
	public void setAmountpaid(float amountpaid) {
		this.amountpaid = amountpaid;
	}
	
	
	public void display()
	{
		System.out.println(loanid +  " " + accountnumber  + " " + rate + " " + principle + " " + tenure + " " + emi+  " "  + amountpaid + " " +tos);
	}
	
	
}
