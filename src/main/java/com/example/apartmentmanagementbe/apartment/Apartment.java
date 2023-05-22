package com.example.apartmentmanagementbe.apartment;

public class Apartment {

	private String apartmentId;
	private int area;
	private int rooms;
	private String status;
	private String owner;
	private int cars;
	private int motorbikes;
	private int bikes;
	private int electricbikes;
	private int electric;
	private int water;
	private int loan;
	
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(String apartmentId, int area, int rooms, String status, String owner, int cars, int motorbikes,
			int bikes, int electricbikes, int electric, int water, int loan) {
		super();
		this.apartmentId = apartmentId;
		this.area = area;
		this.rooms = rooms;
		this.status = status;
		this.owner = owner;
		this.cars = cars;
		this.motorbikes = motorbikes;
		this.bikes = bikes;
		this.electricbikes = electricbikes;
		this.electric = electric;
		this.water = water;
		this.loan = loan;
	}

	public int getLoan() {
		return loan;
	}

	public void setLoan(int loan) {
		this.loan = loan;
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

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}

	public int getMotorbikes() {
		return motorbikes;
	}

	public void setMotorbikes(int motorbikes) {
		this.motorbikes = motorbikes;
	}

	public int getBikes() {
		return bikes;
	}

	public void setBikes(int bikes) {
		this.bikes = bikes;
	}

	public int getElectricbikes() {
		return electricbikes;
	}

	public void setElectricbikes(int electricbikes) {
		this.electricbikes = electricbikes;
	}

	public int getElectric() {
		return electric;
	}

	public void setElectric(int electric) {
		this.electric = electric;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
	
	
	
}
