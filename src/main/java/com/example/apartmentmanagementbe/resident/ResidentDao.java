package com.example.apartmentmanagementbe.resident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

public class ResidentDao {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "tiennguyen1312";
	
	private static final String SELECT_ALL_RESIDENTS = "select * from resident order by apartment_num";
	private static final String SELECT_RESIDENT_BY_ID = "select * from resident where residentid=?";
	private static final String UPDATE_RESIDENT_SQL = "update resident set apartment_num=?, name=?, gender=?, dob=?, phone=?, relationship=? where residentid=?";
	private static final String INSERT_RESIDENT_SQL = "insert into resident(apartment_num, name, gender, dob, phone, relationship) values (?, ?, ?, ?, ?, ?)";
	private static final String DELETE_RESIDENT_BY_ID = "delete from resident where residentid=?";
	
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
	
	public void updateResident(Resident resident) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_RESIDENT_SQL);
			ps.setString(1, resident.getApartmentNum());
			ps.setString(2, resident.getName());
			ps.setString(3, resident.getGender());
			ps.setDate(4, new java.sql.Date(resident.getDob().getTime()));
			ps.setString(5, resident.getPhone());
			ps.setString(6, resident.getRelationship());
			ps.setInt(7, resident.getResidentId());
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void insertResident(Resident resident) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_RESIDENT_SQL);
			ps.setString(1, resident.getApartmentNum());
			ps.setString(2, resident.getName());
			ps.setString(3, resident.getGender());
			ps.setDate(4, new java.sql.Date(resident.getDob().getTime()));
			ps.setString(5, resident.getPhone());
			ps.setString(6, resident.getRelationship());
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteResident(int id) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(DELETE_RESIDENT_BY_ID);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
