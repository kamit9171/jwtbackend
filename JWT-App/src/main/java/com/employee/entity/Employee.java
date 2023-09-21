package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	
	@NotNull(message =" FirstName is Required! ")
	private String firstName;
	
	@NotNull(message =" LastName is Required! ")
	private String lastName;
	
	@NotNull(message =" Date of Joining is Required! ")
	private String dateOfJoining;
	
	private long salary;
	
	public Employee(@NotNull(message =" FirstName is Required! ") String firstName,
	@NotNull(message =" LastName is Required! ") String lastName,
	@NotNull(message =" Date of Joining is Required! ")  String dateOfJoining,
	@NotNull(message =" Salary is Required! ") long salary) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfJoining=dateOfJoining;
		this.salary=salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	

}
