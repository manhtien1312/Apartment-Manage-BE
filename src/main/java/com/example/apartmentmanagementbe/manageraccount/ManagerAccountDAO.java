package com.example.apartmentmanagementbe.manageraccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerAccountDAO {
	
	private String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "tiennguyen1312";
	
	private static final String SELECT_ACOUNT_BY_USERNAME_AND_PASSWORD = "select * from manager_account where username=? and password=?";
	private static final String CHANGE_PASSWORD = "update manager_account set password=? where id=?";
	private static final String INSERT_ACCOUNT = "insert into manager_account (username, password, fullname) values(?, ?, ?)";
	
	public ManagerAccountDAO() {}
	
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
	
	public ManagerAccount getAccount(String username, String password) {
		ManagerAccount account = new ManagerAccount();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ACOUNT_BY_USERNAME_AND_PASSWORD);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				account.setId(0);
				account.setUsername("");
				account.setPassword("");
				account.setFullName("");
			} else {
				account.setId(rs.getInt("id"));
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
	
	public void insertAccount (ManagerAccount account) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_ACCOUNT);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getFullName());
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
