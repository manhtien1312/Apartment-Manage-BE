package com.example.apartmentmanagementbe.bill;

public class ServicePrice {
	
	private int id;
	private int carPrice;
	private int motorbikePrice;
	private int bikePrice;
	private int electricbikePrice;
	private int electricPrice;
	private int waterPrice;
	private int roomServicePrice;
	
	public ServicePrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicePrice(int id, int carPrice, int motorbikePrice, int bikePrice, int electricbikePrice,
			int electricPrice, int waterPrice, int roomServicePrice) {
		super();
		this.id = id;
		this.carPrice = carPrice;
		this.motorbikePrice = motorbikePrice;
		this.bikePrice = bikePrice;
		this.electricbikePrice = electricbikePrice;
		this.electricPrice = electricPrice;
		this.waterPrice = waterPrice;
		this.roomServicePrice = roomServicePrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public int getMotorbikePrice() {
		return motorbikePrice;
	}

	public void setMotorbikePrice(int motorbikePrice) {
		this.motorbikePrice = motorbikePrice;
	}

	public int getBikePrice() {
		return bikePrice;
	}

	public void setBikePrice(int bikePrice) {
		this.bikePrice = bikePrice;
	}

	public int getElectricbikePrice() {
		return electricbikePrice;
	}

	public void setElectricbikePrice(int electricbikePrice) {
		this.electricbikePrice = electricbikePrice;
	}

	public int getElectricPrice() {
		return electricPrice;
	}

	public void setElectricPrice(int electricPrice) {
		this.electricPrice = electricPrice;
	}

	public int getWaterPrice() {
		return waterPrice;
	}

	public void setWaterPrice(int waterPrice) {
		this.waterPrice = waterPrice;
	}

	public int getRoomServicePrice() {
		return roomServicePrice;
	}

	public void setRoomServicePrice(int roomServicePrice) {
		this.roomServicePrice = roomServicePrice;
	}
	
	
	
}
