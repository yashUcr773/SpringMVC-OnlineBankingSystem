package com.springmvc.model;

public class Neft {

	private int transactionID;
	private int recipientnumber;
	private int sendernumber;
	private int amount;
	private String remark;
	private String date;
	private String timestamp;
	private String sendername;
	private String recipientname;
	private String recieverifsc;
	private String senderphone;
	
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getRecipientnumber() {
		return recipientnumber;
	}
	public void setRecipientnumber(int recipientnumber) {
		this.recipientnumber = recipientnumber;
	}
	public int getSendernumber() {
		return sendernumber;
	}
	public void setSendernumber(int sendernumber) {
		this.sendernumber = sendernumber;
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
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	public String getRecipientname() {
		return recipientname;
	}
	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
	}
	public String getRecieverifsc() {
		return recieverifsc;
	}
	public void setRecieverifsc(String recieverifsc) {
		this.recieverifsc = recieverifsc;
	}
	public String getSenderphone() {
		return senderphone;
	}
	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}
	
	public void display()
	{
		
		System.out.println(amount + " " + date + " " + recieverifsc +
				" " + recipientname + " " + recipientnumber + " " + remark + " " + sendername + " " +
				sendernumber + " " + senderphone + " " + timestamp + " " + transactionID );
		
	}
	
	
}
