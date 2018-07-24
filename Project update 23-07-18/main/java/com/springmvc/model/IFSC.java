package com.springmvc.model;

public class IFSC {
	
	private String name;
	private String code;
	private String branch;
	private String address;
	private String contact;
	private String city;
	private String district;
	private String state;
	private String rtgs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRtgs() {
		return rtgs;
	}
	public void setRtgs(String rtgs) {
		this.rtgs = rtgs;
	}
	
	public void display()
	{
		System.out.println(name + " " + code + " " + branch + " " + address + " " + contact + " " + city + " " + 
							district + " " + state + " " + rtgs);
	}
	
	

}
