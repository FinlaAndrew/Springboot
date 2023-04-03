/**
 * 
 */
package com.UST.EmployeeRegistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UST.EmployeeRegistration.model.Employee;
import com.UST.EmployeeRegistration.repositary.EmployeeRepo;

import antlr.collections.List;

/**
 * @author Administrator
 *
 */
@Service
public class Employeeservice {
	@Autowired
	private EmployeeRepo repo;
	public Employee createEmployee(Employee employee) {
		
		return repo.save(employee);
	}
	public java.util.List<Employee> getEmployee() {
		return repo.findAll();
		
	}
	public Employee getEmployeeId(int id) {
		return repo.findById(id).orElse(null);
	}
	public Employee updateEmployee(Employee employee) {
		Employee oldemp=null;
		Optional<Employee>optionalemployee=repo.findById(employee.getId());
		if(optionalemployee.isPresent()) {
			oldemp=optionalemployee.get();
			oldemp.setEmpname(employee.getEmpname());
			oldemp.setAddress(employee.getAddress());
			repo.save(oldemp);
		}else {
			return new Employee();
		}
		
			
		return oldemp;
	}
	public String deleteEmployeeById(int id) {
		repo.deleteById(id);
		return "the employee information is deleted" ;
	}
	

}
