package com.example.apartmentmanagementbe.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDao {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management";
	private String jdbcUsername = "root";
	private String jdbcPassword = "tiennguyen1312";
	
	private static final String SELECT_ALL_EMPLOYEES = "select * from employee order by position";
	private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employeeid=?";
	private static final String UPDATE_EMPLOYEE_SQL = "update employee set name=?, gender=?, dob=?, address=?, phone=?, position=? where employeeid=?";
	private static final String INSERT_EMPLOYEE_SQL = "insert into employee (name, gender, dob, address, phone, position) values (?, ?, ?, ?, ?, ?)";
	private static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employeeid=?";
	
	public EmployeeDao() {}
	
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
	
	public List<Employee> selectAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_EMPLOYEES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("employeeid");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Date dob = rs.getDate("dob");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String position = rs.getString("position");
				employees.add(new Employee(employeeId, name, gender, dob, address, phone, position));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return employees;
	}
	
	public Employee selectEmployee(int employeeId) {
		Employee employee = new Employee();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_EMPLOYEE_BY_ID);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employee.setEmployeeId(rs.getInt("employeeid"));
				employee.setName(rs.getString("name"));;
				employee.setGender(rs.getString("gender"));;
				employee.setDob(rs.getDate("dob"));
				employee.setPhone(rs.getString("phone"));
				employee.setAddress(rs.getString("address"));
				employee.setPosition(rs.getString("position"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_EMPLOYEE_SQL);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getGender());
			ps.setDate(3, new java.sql.Date(employee.getDob().getTime()));
			ps.setString(4, employee.getAddress());
			ps.setString(5, employee.getPhone());
			ps.setString(6, employee.getPosition());
			ps.setInt(7, employee.getEmployeeId());
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void insertEmployee(Employee employee) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE_SQL);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getGender());
			ps.setDate(3, new java.sql.Date(employee.getDob().getTime()));
			ps.setString(4, employee.getAddress());
			ps.setString(5, employee.getPhone());
			ps.setString(6, employee.getPosition());
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(DELETE_EMPLOYEE_BY_ID);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
