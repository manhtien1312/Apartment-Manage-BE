package com.example.apartmentmanagementbe.resident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentDao {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "tiennguyen1312";
	
	private static final String SELECT_ALL_RESIDENTS = "select * from resident";
	private static final String SELECT_RESIDENT_BY_ID = "select * from resident where residentid=?";
	
	public ResidentDao() {}
	
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
	
	public List<Resident> selectAllResidents(){
		List<Resident> residents = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_RESIDENTS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int residentId = rs.getInt("residentid");
				String apartmentNum = rs.getString("apartment_num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Date dob = rs.getDate("dob");
				String phone = rs.getString("phone");
				String relationship = rs.getString("relationship");
				residents.add(new Resident(residentId, apartmentNum, name, gender, dob, phone, relationship));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return residents;
	}
	
	public Resident selectResident(int residentId) {
		Resident resident = new Resident();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_RESIDENT_BY_ID);
			ps.setInt(1, residentId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resident.setResidentId(rs.getInt("residentid"));
				resident.setApartmentNum(rs.getString("apartment_num"));
				resident.setName(rs.getString("name"));;
				resident.setGender(rs.getString("gender"));;
				resident.setDob(rs.getDate("dob"));
				resident.setPhone(rs.getString("phone"));
				resident.setRelationship(rs.getString("relationship"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resident;
	}
	
}
