package com.example.apartmentmanagementbe.bill;

public class Payment {
	
	private int id;
	private int money;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int id, int money) {
		super();
		this.id = id;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
