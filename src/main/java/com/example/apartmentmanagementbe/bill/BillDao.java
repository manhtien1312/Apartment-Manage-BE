package com.example.apartmentmanagementbe.bill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.example.apartmentmanagementbe.apartment.Apartment;
import com.example.apartmentmanagementbe.apartment.ApartmentDao;

public class BillDao {
	
	private String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "tiennguyen1312";
	private ApartmentDao dao = new ApartmentDao();
	
	private static final String GET_LASTEST_BILLS = "select * from bill where (apartment, month) in (select apartment, max(month) from bill group by apartment)";
	private static final String SELECT_BILL_BY_ID = "select * from bill where id=?";
	private static final String SELECT_SERVICE_PRICE = "select * from price_list_service";
	private static final String INSERT_BILL = "insert into bill(month, apartment, car_expense, motorbike_expense, electricbike_expense, bike_expense, service_expense,"
																+ "water_expense, electric_expense, total, loan_before, payed, loan_after, status, water_num, electric_num)"
																+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String PAY_BILL = "update bill set payed=?, loan_after=?, status=? where id=?";
	private static final String UPDATE_LOAN = "update apartment set loan=? where apartmentid=?";
	private static final String UPDATE_APARTMENT_SERVICE = "update apartment set electric=?, water=? where apartmentid=?";
	
	public BillDao() {}
	
	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	public List<Bill> selectLastestBills (){
		List<Bill> lastestBills = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(GET_LASTEST_BILLS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				Date date = rs.getDate("month");
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				int month = calendar.get(Calendar.MONTH)+1;
				int year = calendar.get(Calendar.YEAR);
				String apartment = rs.getString("apartment");
				int carExpense = rs.getInt("car_expense");
				int motorbikeExpense = rs.getInt("motorbike_expense");
				int electricbikeExpense = rs.getInt("electricbike_expense");
				int bikeExpense = rs.getInt("bike_expense");
				int serviceExpense = rs.getInt("service_expense");
				int waterNum = rs.getInt("water_num");
				int waterExpense = rs.getInt("water_expense");
				int electricNum = rs.getInt("electric_num");
				int electricExpense = rs.getInt("electric_expense");
				int total = rs.getInt("total");
				int loanBefore = rs.getInt("loan_before");
				int payed = rs.getInt("payed");
				int loanAfter = rs.getInt("loan_after");
				String status = rs.getInt("status")==0? "Chưa thanh toán" : "Đã thanh toán";
				
				lastestBills.add(new Bill(id, month, year, apartment, carExpense, motorbikeExpense, electricbikeExpense, bikeExpense, serviceExpense, waterNum, waterExpense, electricNum, electricExpense, total, loanBefore, payed, loanAfter, status));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lastestBills;
	}
	
	public Bill selectBill(int id) {
		Bill bill = new Bill();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_BILL_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bill.setId(rs.getInt("id"));
				Date date = rs.getDate("month");
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				bill.setMonth(calendar.get(Calendar.MONTH)+1);
				bill.setYear(calendar.get(Calendar.YEAR));
				bill.setApartment(rs.getString("apartment"));
				bill.setCarExpense(rs.getInt("car_expense"));
				bill.setMotorbikeExpense(rs.getInt("motorbike_expense"));
				bill.setElectricbikeExpense(rs.getInt("electricbike_expense"));
				bill.setBikeExpense(rs.getInt("bike_expense"));
				bill.setServiceExpense(rs.getInt("service_expense"));
				bill.setWaterNum(rs.getInt("water_num"));
				bill.setWaterExpense(rs.getInt("water_expense"));
				bill.setElectricNum(rs.getInt("electric_num"));
				bill.setElectricExpense(rs.getInt("electric_expense"));
				bill.setTotal(rs.getInt("total"));
				bill.setLoanBefore(rs.getInt("loan_before"));
				bill.setPayed(rs.getInt("payed"));
				bill.setLoanAfter(rs.getInt("loan_after"));
				bill.setStatus(rs.getInt("status")==0? "Chưa thanh toán" : "Đã thanh toán");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bill;
	}
	
	public void insertBill(int electricNum, int waterNum, String apartmentid) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_BILL);
			
			Date currentDate = new Date();
			Apartment apartment = dao.selectApartment(apartmentid);
			ServicePrice sp = selectServicePrice();
			
			int carExpense = apartment.getCars() * sp.getCarPrice();
			int motorbikeExpense = apartment.getMotorbikes() * sp.getMotorbikePrice();
			int electricbikeExpense = apartment.getElectricbikes() * sp.getElectricbikePrice();
			int bikeExpense = apartment.getBikes() * sp.getBikePrice();
			int serviceExpense = apartment.getArea() * sp.getRoomServicePrice();
			int waterExpense = (waterNum - apartment.getWater()) * sp.getWaterPrice();
			int electricExpense = (electricNum - apartment.getElectric()) * sp.getElectricPrice();
			int total = carExpense + motorbikeExpense + electricbikeExpense + bikeExpense + serviceExpense + waterExpense + electricExpense;
			
			ps.setDate(1, new java.sql.Date(currentDate.getTime()));
			ps.setString(2, apartment.getApartmentId());
			ps.setInt(3, carExpense);
			ps.setInt(4, motorbikeExpense);
			ps.setInt(5, electricbikeExpense);
			ps.setInt(6, bikeExpense);
			ps.setInt(7, serviceExpense);
			ps.setInt(8, waterExpense);
			ps.setInt(9, electricExpense);
			ps.setInt(10, total);
			ps.setInt(11, apartment.getLoan());
			ps.setInt(12, 0);
			ps.setInt(13, total + apartment.getLoan());
			ps.setInt(14, 0);
			ps.setInt(15, waterNum - apartment.getWater());
			ps.setInt(16, electricNum - apartment.getElectric());
			int result = ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement(UPDATE_APARTMENT_SERVICE);
			ps1.setInt(1, electricNum);
			ps1.setInt(2, waterNum);
			ps1.setString(3, apartmentid);
			result = ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void payBill(int id, int money) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_BILL_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			int loanAfter = 0;
			String apartment = "";
			while (rs.next()) {
				loanAfter = rs.getInt("loan_after");
				apartment = rs.getString("apartment");
			}
			
			PreparedStatement ps1 = con.prepareStatement(PAY_BILL);
			ps1.setInt(1, money);
			ps1.setInt(2, (loanAfter - money));
			ps1.setInt(3, 1);
			ps1.setInt(4, id);
			int result = ps1.executeUpdate();
			
			PreparedStatement ps2 = con.prepareStatement(UPDATE_LOAN);
			ps2.setInt(1, (loanAfter - money));
			ps2.setString(2, apartment);
			result = ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ServicePrice selectServicePrice() {
		ServicePrice sp = new ServicePrice();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_SERVICE_PRICE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sp.setId(rs.getInt("id"));
				sp.setCarPrice(rs.getInt("car_price"));
				sp.setMotorbikePrice(rs.getInt("motorbike_price"));
				sp.setBikePrice(rs.getInt("bike_price"));
				sp.setElectricbikePrice(rs.getInt("electricbike_price"));
				sp.setElectricPrice(rs.getInt("electric_price"));
				sp.setWaterPrice(rs.getInt("water_price"));
				sp.setRoomServicePrice(rs.getInt("room_service_price"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sp;
	}
	
}
