package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.models.Employee;
import com.masai.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo eRepo;
	
	@Override
	public String registerEmployee(Employee e) throws EmployeeException {
		
		if(e==null) throw new EmployeeException("Enter Valid Employee Details");
		
		eRepo.save(e);
		
		return "Sucessfully Inserted";
	}

	@Override
	public Employee getEmployeeByID(Integer id) throws EmployeeException {
		
		return eRepo.findById(id).orElseThrow(()-> new EmployeeException("Enter Valid Employee Id"));
	}

	@Override
	public Employee getReportingmangerByID(Integer id) throws EmployeeException {
		
		Optional<Employee> opt = eRepo.findById(id);
		
		if(opt.isEmpty()) throw new EmployeeException("Enter Valid Employee ID");
		
		Integer mId = opt.get().getManagerId();
		
		return eRepo.findById(mId).orElseThrow(()-> new EmployeeException("This Employee has no Reporting Manager"));
	}

	@Override
	public List<Employee> getAllEmployeeList(Integer id) throws EmployeeException {
		
		Optional<Employee> opt = eRepo.findById(id);
		
		if(opt.isEmpty()) throw new EmployeeException("Enter Valid Manager ID");
		
		List<Employee> emps = eRepo.findAll();
		List<Employee> employeeList = new ArrayList<>();
		for(Employee e:emps) {
			if(e.getManagerId()==opt.get().getId()) {
				employeeList.add(e);
			}
		}

		return employeeList;
	}

}
