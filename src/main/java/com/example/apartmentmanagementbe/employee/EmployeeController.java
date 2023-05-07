package com.example.apartmentmanagementbe.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin
@RestController
public class EmployeeController {

	private EmployeeDao employeeDao = new EmployeeDao();
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(Model model) throws IOException{
		List<Employee> employees = employeeDao.selectAllEmployees();
		model.addAttribute("employees", employees);
		return employees;
	}
	
	@GetMapping("/employee/{employeeid}")
	public Employee getResident(Model model, @PathVariable String employeeid) {
		model.addAttribute("employeeid", employeeid);
		Employee employee = employeeDao.selectEmployee(Integer.valueOf(employeeid));
		model.addAttribute("employee", employee);
		return employee;
	}
	
	@PutMapping("/employee/save/{employeeid}")
	public void updateEmployee (@RequestBody Employee employee, @PathVariable String employeeid)
		throws JsonMappingException, JsonProcessingException, SQLException{
		employeeDao.updateEmployee(employee);
	}
	
	@PostMapping("/employee/add/{employeeid}")
	public void addEmployee(@RequestBody Employee employee, @PathVariable String employeeid)
		throws JsonMappingException, JsonProcessingException, SQLException{
		employeeDao.insertEmployee(employee);
	}
	
	@GetMapping("/employee/delete/{employeeid}")
	public void deleteEmployee(@PathVariable String employeeid) {
		employeeDao.deleteEmployee(Integer.valueOf(employeeid));
	}
	
}
