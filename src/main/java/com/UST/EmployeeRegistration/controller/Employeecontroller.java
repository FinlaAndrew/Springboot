/**
 * 
 */
package com.UST.EmployeeRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UST.EmployeeRegistration.model.Employee;
import com.UST.EmployeeRegistration.service.Employeeservice;



/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("registration")
public class Employeecontroller {
	@Autowired
	public Employeeservice employeeservice;
	
	@PostMapping("/addemps")
	public Employee addemp(@RequestBody Employee employee) {
		return employeeservice.createEmployee(employee);
	}
	@GetMapping("/employees")
	public List<Employee> getALLEmployee(){
		return employeeservice.getEmployee();
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeservice.getEmployeeId(id);
	}
	@PutMapping("/updateemployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeservice.updateEmployee(employee);
	}
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeservice.deleteEmployeeById(id);
	}
}
