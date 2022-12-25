package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Driver;
import com.masai.repo.DriverRepo;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepo dRepo;

	@Override
	public Driver registerDriver(Driver driver) {
		
		Driver d = dRepo.save(driver);
		return d;
	}

}
