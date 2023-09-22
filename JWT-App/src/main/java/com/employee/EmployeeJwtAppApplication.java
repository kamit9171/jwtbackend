package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.employee")
public class EmployeeJwtAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeJwtAppApplication.class, args);
	}
}
