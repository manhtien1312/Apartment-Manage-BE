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
	
	private static final String SELECT_ALL_APARTMENTS = "select * from apartment order by apartmentid";
	private static final String SELECT_APARTMENT_BY_ID = "select * from apartment where apartmentid=?";
	private static final String UPDATE_APARTMENT_SQL = "update apartment set area=?, rooms=?, status=?, owner=? where apartmentid=?";
	private static final String UPDATE_APARTMENT_OWNER = "update apartment set status=?, owner=? where apartmentid=?";
	
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
				int cars = rs.getInt("cars");
				int motorbikes = rs.getInt("motorbikes");
				int bikes = rs.getInt("bikes");
				int electricbikes = rs.getInt("electricbikes");
				int electric = rs.getInt("electric");
				int water = rs.getInt("water");
				int loan = rs.getInt("loan");
				apartments.add(new Apartment(apartmentId, area, rooms, status, owner, cars, motorbikes, bikes, electricbikes, electric, water, loan));
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
				apartment.setCars(rs.getInt("cars"));
				apartment.setMotorbikes(rs.getInt("motorbikes"));
				apartment.setBikes(rs.getInt("bikes"));
				apartment.setElectricbikes(rs.getInt("electricbikes"));
				apartment.setElectric(rs.getInt("electric"));
				apartment.setWater(rs.getInt("water"));
				apartment.setLoan(rs.getInt("loan"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return apartment;
	}
	
	public void updateApartment(Apartment apartment) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_APARTMENT_SQL);
			int result = 0;
			ps.setInt(1, apartment.getArea());
			ps.setInt(2, apartment.getRooms());
			ps.setString(3, apartment.getStatus());
			ps.setString(4, apartment.getOwner());
			ps.setString(5, apartment.getApartmentId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateApartmentOwner(String status, String owner, String apartmentId) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_APARTMENT_OWNER);
			int result = 0;
			ps.setString(1, status);
			ps.setString(2, owner);
			ps.setString(3, apartmentId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
