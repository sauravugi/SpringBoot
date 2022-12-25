package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.models.Employee;

public interface EmployeeService {
	
	String registerEmployee(Employee e) throws EmployeeException;
	
	Employee getEmployeeByID(Integer id) throws EmployeeException;
	
	Employee getReportingmangerByID(Integer id) throws EmployeeException;
	
	List<Employee> getAllEmployeeList(Integer id) throws EmployeeException;

}
