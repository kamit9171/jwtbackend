package com.employee.services;


import java.util.List;
import java.util.Optional;

import com.employee.entity.Employee;

public interface EmployeeService {
	//All the Function 
	
	public List<Employee> getAllEmployees();
	
	public Employee addEmployee(Employee employee);
	
	public Boolean existById(Integer id);
	
	public Optional<Employee> getEmployeeById(Integer id);
	
	public Optional<Employee > updateEmployee(Integer id,Employee employee);
	
	public void deleteEmployeeRecordById(Integer id);
	
	
	

}

