package com.example.apartmentmanagementbe.employee;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
}
