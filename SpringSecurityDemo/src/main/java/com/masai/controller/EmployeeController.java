package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.models.Employee;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	@PostMapping("/reg-employees")
	public ResponseEntity<String> registerEmployeeHandler(@Valid @RequestBody Employee e) throws EmployeeException{
		
			String msg = eService.registerEmployee(e);
			
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-employees/{id}")
	public ResponseEntity<Employee> getEmployeeByIdHandler(@Valid @PathVariable Integer id) throws EmployeeException{
		
			Employee e = eService.getEmployeeByID(id);
			
			return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	@GetMapping("/get-employees-manager/{id}")
	public ResponseEntity<Employee> getReportingManagerHandler(@Valid @PathVariable Integer id) throws EmployeeException{
		
			Employee e = eService.getReportingmangerByID(id);
			
			return new ResponseEntity<Employee>(e, HttpStatus.OK);
			
	}
	@GetMapping("/get-all-reportees/{id}")
	public ResponseEntity<List<Employee>> getAllEmpoyeesUnderRMHandler(@Valid @PathVariable Integer id) throws EmployeeException{
		
			List<Employee> e = eService.getAllEmployeeList(id);
			
			return new ResponseEntity<List<Employee>>(e, HttpStatus.OK);
	}
}
