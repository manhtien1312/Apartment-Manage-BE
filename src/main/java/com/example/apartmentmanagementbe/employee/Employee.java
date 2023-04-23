package com.example.apartmentmanagementbe.employee;

import java.util.Date;

public class Employee {
	
	private int employeeId;
	private String name;
	private String gender;
	private Date dob;
	private String address;
	private String phone;
	private String position;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int employeeId, String name, String gender, Date dob, String address, String phone,
			String position) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.position = position;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}
	
	

}
