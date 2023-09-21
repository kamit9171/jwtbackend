package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer>{
	
	//findAllByOrderByIdAsc method is used to ORder by Employee list in Ascending Order
	public List<Employee> findAllByOrderByIdAsc();
	
	//findAllByOrderByIdDesc method is used to ORder by Employee list in descending Order
	//public List<Employee> findAllByOrderByDesc();

}
