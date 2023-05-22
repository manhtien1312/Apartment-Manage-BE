package com.example.apartmentmanagementbe.bill;

import java.time.YearMonth;

public class BillInitiation {

	private YearMonth month;
	private int electricNum;
	private int waterNum;
	
	public BillInitiation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillInitiation(YearMonth month, int electricNum, int waterNum) {
		super();
		this.month = month;
		this.electricNum = electricNum;
		this.waterNum = waterNum;
	}

	public YearMonth getMonth() {
		return month;
	}

	public void setMonth(YearMonth month) {
		this.month = month;
	}

	public int getElectricNum() {
		return electricNum;
	}

	public void setElectricNum(int electricNum) {
		this.electricNum = electricNum;
	}

	public int getWaterNum() {
		return waterNum;
	}

	public void setWaterNum(int waterNum) {
		this.waterNum = waterNum;
	}
	
	
	
}
