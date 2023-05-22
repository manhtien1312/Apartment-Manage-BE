package com.example.apartmentmanagementbe.bill;

public class Bill {
	
	private int id;
	private int month;
	private int year;
	private String apartment;
	private int carExpense;
	private int motorbikeExpense;
	private int electricbikeExpense;
	private int bikeExpense;
	private int serviceExpense;
	private int waterNum;
	private int waterExpense;
	private int electricNum;
	private int electricExpense;
	private int total;
	private int loanBefore;
	private int payed;
	private int loanAfter;
	private String status;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int id, int month, int year, String apartment, int carExpense, int motorbikeExpense,
			int electricbikeExpense, int bikeExpense, int serviceExpense, int waterNum, int waterExpense, int electricNum,
			int electricExpense, int total, int loanBefore, int payed, int loanAfter, String status) {
		super();
		this.id = id;
		this.month = month;
		this.year = year;
		this.apartment = apartment;
		this.carExpense = carExpense;
		this.motorbikeExpense = motorbikeExpense;
		this.electricbikeExpense = electricbikeExpense;
		this.bikeExpense = bikeExpense;
		this.serviceExpense = serviceExpense;
		this.waterNum = waterNum;
		this.waterExpense = waterExpense;
		this.electricNum = electricNum;
		this.electricExpense = electricExpense;
		this.total = total;
		this.loanBefore = loanBefore;
		this.payed = payed;
		this.loanAfter = loanAfter;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public int getCarExpense() {
		return carExpense;
	}

	public void setCarExpense(int carExpense) {
		this.carExpense = carExpense;
	}

	public int getWaterNum() {
		return waterNum;
	}

	public void setWaterNum(int waterNum) {
		this.waterNum = waterNum;
	}

	public int getElectricNum() {
		return electricNum;
	}

	public void setElectricNum(int electricNum) {
		this.electricNum = electricNum;
	}

	public int getMotorbikeExpense() {
		return motorbikeExpense;
	}

	public void setMotorbikeExpense(int motorbikeExpense) {
		this.motorbikeExpense = motorbikeExpense;
	}

	public int getElectricbikeExpense() {
		return electricbikeExpense;
	}

	public void setElectricbikeExpense(int electricbikeExpense) {
		this.electricbikeExpense = electricbikeExpense;
	}

	public int getBikeExpense() {
		return bikeExpense;
	}

	public void setBikeExpense(int bikeExpense) {
		this.bikeExpense = bikeExpense;
	}

	public int getServiceExpense() {
		return serviceExpense;
	}

	public void setServiceExpense(int serviceExpense) {
		this.serviceExpense = serviceExpense;
	}

	public int getWaterExpense() {
		return waterExpense;
	}

	public void setWaterExpense(int waterExpense) {
		this.waterExpense = waterExpense;
	}

	public int getElectricExpense() {
		return electricExpense;
	}

	public void setElectricExpense(int electricExpense) {
		this.electricExpense = electricExpense;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLoanBefore() {
		return loanBefore;
	}

	public void setLoanBefore(int loanBefore) {
		this.loanBefore = loanBefore;
	}

	public int getPayed() {
		return payed;
	}

	public void setPayed(int payed) {
		this.payed = payed;
	}

	public int getLoanAfter() {
		return loanAfter;
	}

	public void setLoanAfter(int loanAfter) {
		this.loanAfter = loanAfter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
