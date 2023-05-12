package com.example.apartmentmanagementbe.residentaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResidentAccountDAO {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "tiennguyen1312";
	
	private static final String SELECT_ACOUNT_BY_USERNAME_AND_PASSWORD = "select * from resident_account where username=? and password=?";
	private static final String CHANGE_PASSWORD = "update resident_account set password=? where id=?";
	
	public ResidentAccountDAO() {}
	
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
	
	public ResidentAccount getAccount(String username, String password) {
		ResidentAccount account = new ResidentAccount();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ACOUNT_BY_USERNAME_AND_PASSWORD);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				account.setId("");
				account.setUsername("");
				account.setPassword("");
				account.setFullName("");
			} else {
				account.setId(rs.getString("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullName(rs.getString("fullname"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return account;
	}
	
}
