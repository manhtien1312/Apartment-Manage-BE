package com.example.apartmentmanagementbe.apartment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDao {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "tiennguyen1312";
	
	private static final String SELECT_ALL_APARTMENTS = "select * from apartment";
	private static final String SELECT_APARTMENT_BY_ID = "select * from apartment where apartmentid=?";
	
	public ApartmentDao() {}
	
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
	
	public List<Apartment> selectAllApartments(){
		List<Apartment> apartments = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_APARTMENTS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String apartmentId = rs.getString("apartmentid");
				int area = rs.getInt("area");
				int rooms = rs.getInt("rooms");
				String status = rs.getString("status");
				String owner = "";
				if (rs.getString("owner") != null) owner = rs.getString("owner");
				apartments.add(new Apartment(apartmentId, area, rooms, status, owner));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return apartments;
	}
	
	public Apartment selectApartment(String apartmentid) {
		Apartment apartment = new Apartment();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_APARTMENT_BY_ID);
			ps.setString(1, apartmentid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				apartment.setApartmentId(rs.getString("apartmentid"));
				apartment.setArea(rs.getInt("area"));
				apartment.setRooms(rs.getInt("rooms"));
				apartment.setStatus(rs.getString("status"));
				String owner = "";
				if (rs.getString("owner") != null) owner = rs.getString("owner");
				apartment.setOwner(owner);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return apartment;
	}
	
	
}
