package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	Employee findByEmail(String email);

}
