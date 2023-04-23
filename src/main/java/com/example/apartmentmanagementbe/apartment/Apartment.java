package com.example.apartmentmanagementbe.apartment;

public class Apartment {

	private String apartmentId;
	private int area;
	private int rooms;
	private String status;
	private String owner;
	
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(String apartmentId, int area, int rooms, String status, String owner) {
		super();
		this.apartmentId = apartmentId;
		this.area = area;
		this.rooms = rooms;
		this.status = status;
		this.owner = owner;
	}

	public String getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(String apartmentId) {
		this.apartmentId = apartmentId;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
}
