package com.springmvc.model;

public class Transactions {
	
	private int transactionID;
	private int recipient;
	private int sender;
	private int amount;
	private String remark;
	private String date;
	private String timestamp;
	
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getRecipient() {
		return recipient;
	}
	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
	public void displayall()
	{
		
		System.out.println("TransactionID = " + transactionID);
		System.out.println("Sender = " + sender);
		System.out.println("Recipient = " + recipient);
		System.out.println("Remark = " + remark);
		System.out.println("Amount = " + amount);
		System.out.println("Date = " + date);
		System.out.println("Timestamp = " + timestamp);
		System.out.println();
		
	}

}
