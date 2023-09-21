package com.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	// getAllEmployees method is used to get all the Employee List and OrderBy
	// Ascending Order
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAllByOrderByIdAsc();
	}

	// getAllEmployees method is used to get all the Employee List and OrderBy
	// Descending Order
/*	public List<Employee> getAllEmployeesDesc() {
		return employeeRepository.findAllByOrderByIdDesc();
	}
*/
	// addEmployee method is used to create Employee Record
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Boolean existById(Integer id) {
		return employeeRepository.existsById(id);
	}

	// getEmployeeById service method is used to return the Employee from repository
	// by using of findById
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	// updateEmployee method is used to update Employee record by using of Id
	public Optional<Employee> updateEmployee(Integer id, Employee employee) {
		return employeeRepository.findById(id).map((emp) -> {
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setDateOfJoining(employee.getDateOfJoining());
			emp.setSalary(employee.getSalary());
			return employeeRepository.save(emp);
		});
	}

	// deleteEmployeeRecordById method is used to delete Employee by using of Id
	public void deleteEmployeeRecordById(Integer id) {
		employeeRepository.deleteById(id);
	}

}
