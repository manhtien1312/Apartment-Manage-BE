package com.example.apartmentmanagementbe.resident;

import java.util.Date;

public class Resident {

	private int residentId;
	private String apartmentNum;
	private String name;
	private String gender;
	private Date dob;
	private String phone;
	private String relationship;
	
	
	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Resident(int residentId, String apartmentNum, String name, String gender, Date dob, String phone,
			String relationship) {
		super();
		this.residentId = residentId;
		this.apartmentNum = apartmentNum;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.relationship = relationship;
	}


	public int getResidentId() {
		return residentId;
	}


	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}


	public String getApartmentNum() {
		return apartmentNum;
	}


	public void setApartmentNum(String apartmentNum) {
		this.apartmentNum = apartmentNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getRelationship() {
		return relationship;
	}


	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	

}
