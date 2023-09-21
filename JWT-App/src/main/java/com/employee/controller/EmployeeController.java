package com.employee.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.services.EmployeeService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployees() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<>(list, headers, HttpStatus.OK);
	}

	// getEmployeeById method is used to get the Employee record by using of ID from
	// database with the help of front-end Angular application by using REST API
	// end-point "/employee/{id}"
	@RequestMapping(value = "employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		Optional<Employee> getOptinoalEmp = employeeService.getEmployeeById(Integer.parseInt(id));
		if (getOptinoalEmp.isEmpty()) {
			return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
		}
		Employee employee = getOptinoalEmp.get();
		return new ResponseEntity<>(employee, headers, HttpStatus.OK);
	}

	// createEmployee method is used to create new Employee record from database
	// with the help of front-end Angular application by using REST API end-point
	// "/employee"
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		Employee createNewEmployee = employeeService.addEmployee(employee);
		if (createNewEmployee == null) {
			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(createNewEmployee, headers, HttpStatus.CREATED);
	}

	// updateEmployee method is used to update Employee record by using of Employee
	// ID from database with the help of front-end Angular application by using of
	// REST API end-point "/employee/{id}"
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@PathVariable("id") String id, @Valid @RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		Optional<Employee> updateOptinoalEmp = employeeService.updateEmployee(Integer.parseInt(id), employee);
		if (updateOptinoalEmp.isEmpty()) {
			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(updateOptinoalEmp.get(), headers, HttpStatus.OK);
	}

	// deleteEmployeeById method is used to delete Employee record by using of
	// Employee ID from database with the help of front-end Angular application by
	// using of REST API end-point "/employee/{id}"
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") String id) {
		employeeService.deleteEmployeeRecordById(Integer.parseInt(id));
		return new ResponseEntity<>("Employee " + id + " has been deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{ids}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployeesByIds(@PathVariable("ids") List<String> ids) {
		if (ids.size() > 0) {
			ids.forEach(deletedEmpRecord -> {
				if (employeeService.existById(Integer.parseInt(deletedEmpRecord))) {
					employeeService.deleteEmployeeRecordById(Integer.parseInt(deletedEmpRecord));
				}
			});
		}
		Map<String, String> response = new HashMap<>();
		response.put("message", "Employee Record has been deleted successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

